package ru.job4j.tracker;

import ru.job4j.tracker.Output;

public class ValidateInput implements Input {
    private final Output output;
    private final Input input;

    public ValidateInput(Output output, Input input) {
        this.output = output;
        this.input = input;
    }

    @Override
    public String askStr(String question) {
        return input.askStr(question);
    }

    @Override
    public int askInt(String question) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = input.askInt(question);
                invalid = false;
            } catch (NumberFormatException nfe) {
                output.println("Пожалуйста, введите корректные данные (число).");
            }
        } while (invalid);
        return value;
    }

    @Override
    public int askInt(String question, int max) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = input.askInt(question, max);
                invalid = false;
            } catch (NumberFormatException nfe) {
                output.println("Пожалуйста, введите корректные данные (число).");
            } catch (IllegalStateException ise) {
                output.println("Пожалуйста, выберите пункт меню от 0 до " + (max - 1));
            }
        } while (invalid);
        return value;
    }
}