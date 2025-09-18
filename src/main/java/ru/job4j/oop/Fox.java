package ru.job4j.oop;

public class Fox {

    public void tryEat(Ball ball) {
        System.out.print("Лиса пытается съесть колобка. ");
        ball.tryRun(true);
    }
}
