package ru.job4j.polymorphism;

public class Bus implements Transport {
    @Override
    public void move() {
        System.out.println("Автобус движется по маршруту");
    }

    @Override
    public void passengers(int count) {
        System.out.println("В автобусе " + count + " пассажиров");
    }

    @Override
    public int refuel(int fuel) {
        int pricePerLiter = 50;
        int cost = fuel * pricePerLiter;
        System.out.println("Автобус заправлен на " + fuel + " литров. Стоимость: " + cost + " рублей");
        return cost;
    }
}
