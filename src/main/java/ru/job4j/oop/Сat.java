package ru.job4j.oop;

public class Сat {

    private String food;
    private String name;

    public void show() {
        System.out.println("Кличка: " + this.name + ", еда: " + this.food);
    }

    public void eat(String meat) {
        this.food = meat;
    }

    public void giveNick(String nick) {
        this.name = nick;
    }

    public static void main(String[] args) {
        System.out.println("There is gav's food.");
        Сat gav = new Сat();
        gav.giveNick("Gav");  // Устанавливаем кличку
        gav.eat("cutlet");
        gav.show();

        System.out.println("There is black's food.");
        Сat black = new Сat();
        black.giveNick("Black");  // Устанавливаем кличку
        black.eat("fish");
        black.show();
    }
}