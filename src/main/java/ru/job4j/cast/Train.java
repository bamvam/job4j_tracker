package ru.job4j.cast;

public class Train implements Vehicle {
    @Override
    public void move() {
        System.out.println("Поезд движется по рельсам со скоростью 120 км/ч");
    }

    @Override
    public String getDescription() {
        return "Поезд - железнодорожное транспортное средство, состоящее из локомотива и вагонов";
    }
}
