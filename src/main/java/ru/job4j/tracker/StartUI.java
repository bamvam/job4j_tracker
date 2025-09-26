package ru.job4j.tracker;

import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class StartUI {
    public static void main(String[] args) {
        Item item = new Item();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(
                "dd-MMMM-EEEE-yyyy HH:mm:ss",
                new Locale("ru")
        );
        String formattedDate = item.getCreated().format(formatter);
        System.out.println(formattedDate);
    }
}