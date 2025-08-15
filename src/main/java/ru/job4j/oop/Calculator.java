package ru.job4j.oop;

public class Calculator {
    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public int multiply(int a) {
        return x * a;
    }

    public static int minus(int y) {
        return y - x;
    }

    public double divide(int a) {
        return (double) a / x;
    }

    public double sumAllOperation(int num) {
        return sum(num) + multiply(num) + minus(num) + divide(num);
    }

    public static void main(String[] args) {
        System.out.println("minus(10): " + Calculator.minus(10));

        Calculator calculator = new Calculator();
        System.out.println("divide(15): " + calculator.divide(15));
        System.out.println("sumAllOperation(10): " + calculator.sumAllOperation(10));
    }
}