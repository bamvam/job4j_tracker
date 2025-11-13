package ru.job4j.tracker;

public class ValidateInput implements Input {
    private final Input input;
    private final Output output;

    public ValidateInput(Input input, Output output) {
        this.input = input;
        this.output = output;
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
                output.println("Пожалуйста, введите корректные данные (число)");
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
                value = input.askInt(question);
                if (value < 0 || value >= max) {
                    output.println("Неверный ввод, вы можете выбрать: 0 .. " + (max - 1));
                } else {
                    invalid = false;
                }
            } catch (NumberFormatException nfe) {
                output.println("Пожалуйста, введите корректные данные (число)");
            }
        } while (invalid);
        return value;
    }
}