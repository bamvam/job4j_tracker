package ru.job4j.oop;

public class College {
    public static void main(String[] args) {
        Freshman freshman = new Freshman("Иван Иванов", 2024);

        Student student = freshman;
        System.out.println("Имя студента: " + student.getName());

        Object object = student;
        System.out.println("Объект: " + object.toString());

        Object directObject = freshman;
        System.out.println("Прямое приведение: " + directObject.toString());

        Student backToStudent = (Student) directObject;
        System.out.println("Обратное приведение: " + backToStudent.getName());

        Freshman backToFreshman = (Freshman) backToStudent;
        System.out.println("Исходный тип: " + backToFreshman.getName() + ", год: " + backToFreshman.getYear());
    }
}
