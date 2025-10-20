package ru.job4j.cast;

public class Bus implements Vehicle {
    @Override
    public void move() {
        System.out.println("Автобус едет по скоростной трассе в потоке машин");
    }

    @Override
    public String getDescription() {
        return "Автобус - дорожное транспортное средство для перевозки пассажиров";
    }
}
