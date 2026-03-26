package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        String leftNum = left.split("\\.")[0];
        String rightNum = right.split("\\.")[0];

        int leftInt = Integer.parseInt(leftNum);
        int rightInt = Integer.parseInt(rightNum);

        return Integer.compare(leftInt, rightInt);
    }
}
