package ru.job4j.tracker;

import java.util.Scanner;

public class StartUI {

    public static void createItem(Scanner scanner, Tracker tracker) {
        System.out.println("=== Создание новой заявки ===");
        System.out.print("Введите имя: ");
        String name = scanner.nextLine();
        Item item = new Item(name);
        tracker.add(item);
        System.out.println("Добавленная заявка: " + item);
    }

    public static void findAllItems(Tracker tracker) {
        System.out.println("=== Вывод всех заявок ===");
        Item[] items = tracker.findAll();
        if (items.length > 0) {
            for (Item item : items) {
                System.out.println(item);
            }
        } else {
            System.out.println("Хранилище еще не содержит заявок");
        }
    }

    public static void replaceItem(Scanner scanner, Tracker tracker) {
        System.out.println("=== Редактирование заявки ===");
        System.out.print("Введите id: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Введите имя: ");
        String name = scanner.nextLine();
        Item item = new Item(name);
        if (tracker.replace(id, item)) {
            System.out.println("Заявка изменена успешно.");
        } else {
            System.out.println("Ошибка замены заявки.");
        }
    }

    public static void deleteItem(Scanner scanner, Tracker tracker) {
        System.out.println("=== Удаление заявки ===");
        System.out.print("Введите id: ");
        int id = Integer.parseInt(scanner.nextLine());
        Item item = tracker.findById(id);
        if (item != null) {
            tracker.delete(id);
            System.out.println("Заявка удалена успешно.");
        } else {
            System.out.println("Ошибка удаления заявки.");
        }
    }

    public static void findItemById(Scanner scanner, Tracker tracker) {
        System.out.println("=== Вывод заявки по id ===");
        System.out.print("Введите id: ");
        int id = Integer.parseInt(scanner.nextLine());
        Item item = tracker.findById(id);
        if (item != null) {
            System.out.println(item);
        } else {
            System.out.println("Заявка с введенным id: " + id + " не найдена.");
        }
    }

    public static void findItemByName(Scanner scanner, Tracker tracker) {
        System.out.println("=== Вывод заявок по имени ===");
        System.out.print("Введите имя: ");
        String name = scanner.nextLine();
        Item[] items = tracker.findByName(name);
        if (items.length > 0) {
            for (Item item : items) {
                System.out.println(item);
            }
        } else {
            System.out.println("Заявки с именем: " + name + " не найдены.");
        }
    }

    public void init(Scanner scanner, Tracker tracker) {
        boolean run = true;
        while (run) {
            showMenu();
            System.out.print("Выбрать: ");
            int select = Integer.parseInt(scanner.nextLine());
            if (select == 0) {
                createItem(scanner, tracker);
            } else if (select == 1) {
                findAllItems(tracker);
            } else if (select == 2) {
                replaceItem(scanner, tracker);
            } else if (select == 3) {
                deleteItem(scanner, tracker);
            } else if (select == 4) {
                findItemById(scanner, tracker);
            } else if (select == 5) {
                findItemByName(scanner, tracker);
            } else if (select == 6) {
                run = false;
            }
        }
    }

    private void showMenu() {
        String[] menu = {
                "Добавить новую заявку",
                "Показать все заявки",
                "Редактировать заявку",
                "Удалить заявку",
                "Найти заявку по id",
                "Найти заявки по имени",
                "Выйти из программы"
        };
        for (int i = 0; i < menu.length; i++) {
            System.out.println(i + ". " + menu[i]);
        }
    }
}