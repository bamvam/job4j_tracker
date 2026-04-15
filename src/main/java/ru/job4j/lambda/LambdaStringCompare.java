package ru.job4j.lambda;

import java.util.Comparator;

public class LambdaStringCompare {
    public static void main(String[] args) {
        Comparator<String> comparatorText = (left, right) -> left.compareTo(right);
        Comparator<String> comparatorDescSize = (left, right) -> Integer.compare(right.length(), left.length());
        String[] words = {"apple", "pie", "banana", "kiwi", "strawberry"};
        java.util.Arrays.sort(words, comparatorText);
        System.out.println("By alphabet: " + java.util.Arrays.toString(words));
        java.util.Arrays.sort(words, comparatorDescSize);
        System.out.println("By length desc: " + java.util.Arrays.toString(words));
    }
}