package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        // Создаем 4 книги
        Book book1 = new Book("Java Basics", 300);
        Book book2 = new Book("Algorithms", 450);
        Book book3 = new Book("Clean code", 500);
        Book book4 = new Book("Data Structures", 400);

        Book[] books = new Book[4];
        books[0] = book1;
        books[1] = book2;
        books[2] = book3;
        books[3] = book4;

        System.out.println("Все книги в библиотеке:");
        for (int i = 0; i < books.length; i++) {
            Book book = books[i];
            System.out.println(book.getName() + " - " + book.getPages() + " страниц");
        }

        System.out.println("После замены книг с индексом 0 и 3:");
        Book temp = books[0];
        books[0] = books[3];
        books[3] = temp;

        for (int i = 0; i < books.length; i++) {
            Book book = books[i];
            System.out.println(book.getName() + " - " + book.getPages() + " страниц");
        }

        System.out.println("Книги с названием 'Clean code':");
        for (int i = 0; i < books.length; i++) {
            Book book = books[i];
            if ("Clean code".equals(book.getName())) {
                System.out.println(book.getName() + " - " + book.getPages() + " страниц");
            }
        }
    }
}
