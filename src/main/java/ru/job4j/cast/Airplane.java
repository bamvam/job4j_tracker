package ru.job4j.cast;

public class Airplane implements Vehicle {
    @Override
    public void move() {
        System.out.println("Самолет летит по воздуху на высоте 10 000 метров");
    }

    @Override
    public String getDescription() {
        return "Самолет - воздушное транспортное средство с крыльями и реактивными двигателями";
    }
}