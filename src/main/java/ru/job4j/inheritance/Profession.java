package ru.job4j.inheritance;

public class Profession {
    private boolean degree;

    public Profession(boolean degree) {
        this.degree = degree;
    }
}

class Engineer extends Profession {
    private int experience;

    public Engineer(int experience, boolean degree) {
        super(degree);
        this.experience = experience;
    }
}

class Programmer extends Engineer {
    private String programLanguage;

    public Programmer(String programLanguage, int experience, boolean degree) {
        super(experience, degree);
        this.programLanguage = programLanguage;
    }
}