package ru.job4j.tracker;

import java.util.List;

public class FindAllAction implements UserAction {
    private final Output out;

    public FindAllAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Показать все заявки";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Вывод всех заявок ===");
        List<Item> items = tracker.findAll();
        if (items.isEmpty()) {
            out.println("Хранилище ещё не содержит заявок.");
        } else {
            for (Item item : items) {
                out.println(item);
            }
        }
        return true;
    }
}