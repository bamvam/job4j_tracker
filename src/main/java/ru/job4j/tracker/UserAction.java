package ru.job4j.tracker;

import ru.job4j.tracker.Input;
import ru.job4j.tracker.Tracker;
import ru.job4j.tracker.Item;

public interface UserAction {
    String name();

    boolean execute(Input input, Tracker tracker);
}