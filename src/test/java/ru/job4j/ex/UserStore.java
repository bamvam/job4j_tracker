package ru.job4j.ex;

public class UserStore {

    public static User findUser(User[] users, String login) throws UserNotFoundException {
        for (User user : users) {
            if (user.getUsername().equals(login)) {
                return user;
            }
        }
        throw new UserNotFoundException("Пользователь с логином '" + login + "' не найден");
    }

    public static boolean validate(User user) throws UserInvalidException {
        if (user == null) {
            throw new UserInvalidException("Пользователь не существует");
        }
        if (!user.isValid()) {
            throw new UserInvalidException("Пользователь не валидный");
        }
        if (user.getUsername().length() < 3) {
            throw new UserInvalidException("Имя пользователя должно содержать не менее 3 символов");
        }
        return true;
    }

    public static void main(String[] args) {
        User[] users = {
                new User("Petr Arsentev", true),
                new User("Ivan", false), // не валидный пользователь
                new User("Al", true)     // имя меньше 3 символов
        };

        try {
            User user1 = findUser(users, "Petr Arsentev");
            validate(user1);
            System.out.println("This user has an access");

            User user2 = findUser(users, "NonExistentUser");
            validate(user2);

        } catch (UserInvalidException e) {
            System.out.println("Пользователь не валидный: " + e.getMessage());
        } catch (UserNotFoundException e) {
            System.out.println("Пользователь не найден: " + e.getMessage());
        }

        System.out.println("\nДополнительные тесты:");

        try {
            User invalidUser = findUser(users, "Ivan");
            validate(invalidUser);
        } catch (UserInvalidException e) {
            System.out.println("Пользователь не валидный: " + e.getMessage());
        } catch (UserNotFoundException e) {
            System.out.println("Пользователь не найден: " + e.getMessage());
        }

        try {
            User shortNameUser = findUser(users, "Al");
            validate(shortNameUser);
        } catch (UserInvalidException e) {
            System.out.println("Пользователь не валидный: " + e.getMessage());
        } catch (UserNotFoundException e) {
            System.out.println("Пользователь не найден: " + e.getMessage());
        }

        try {
            User nonExistentUser = findUser(users, "Unknown");
            validate(nonExistentUser);
        } catch (UserInvalidException e) {
            System.out.println("Пользователь не валидный: " + e.getMessage());
        } catch (UserNotFoundException e) {
            System.out.println("Пользователь не найден: " + e.getMessage());
        }
    }
}
