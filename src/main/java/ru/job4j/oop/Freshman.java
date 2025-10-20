package ru.job4j.oop;

public class Freshman extends Student {
    private int year;

    public Freshman(String name, int year) {
        super(name); // Вызов конструктора родительского класса
        this.year = year;
    }

    public Freshman() {
        super(); // Вызов конструктора по умолчанию родительского класса
    }

    public int getYear() {
        return year;
    }
}
