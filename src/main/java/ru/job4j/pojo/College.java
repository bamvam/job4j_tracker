package ru.job4j.pojo;

import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setFio("Иванов Иван Иванович");
        student.setGroup("Группа 101");
        student.setDate(new Date());

        System.out.println("Студент: " + student.getFio()
                + ", Группа: " + student.getGroup()
                + ", Дата поступления: " + student.getDate());
    }
}
