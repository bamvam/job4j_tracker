package ru.job4j.oop;

public class Error {
    private boolean active;
    private int status;
    private String message;

    public Error() {
    }

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public void printInfo() {
        System.out.println("Active: " + active);
        System.out.println("Status: " + status);
        System.out.println("Message: " + message);
        System.out.println();
    }

    public static void main(String[] args) {
        Error defaultError = new Error();
        defaultError.printInfo();

        Error fileNotFound = new Error(true, 404, "File not found");
        Error serverError = new Error(true, 500, "Internal server error");
        Error warning = new Error(false, 100, "Just a warning");

        fileNotFound.printInfo();
        serverError.printInfo();
        warning.printInfo();
    }
}