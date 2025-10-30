package ru.job4j.ex;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FactorialTest {

    @Test
    public void whenCalculateFactorialForFiveThenOneHundredTwenty() {
        Factorial factorial = new Factorial();
        int number = 5;
        int expected = 120; // 5! = 1 * 2 * 3 * 4 * 5 = 120
        int result = factorial.calc(number);
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void whenCalculateFactorialForZeroThenOne() {
        Factorial factorial = new Factorial();
        int number = 0;
        int expected = 1; // 0! = 1
        int result = factorial.calc(number);
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void whenCalculateFactorialForOneThenOne() {
        Factorial factorial = new Factorial();
        int number = 1;
        int expected = 1; // 1! = 1
        int result = factorial.calc(number);
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void whenNumberIsNegativeThenException() {
        Factorial factorial = new Factorial();
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    factorial.calc(-1);
                });
        assertThat(exception.getMessage()).isEqualTo("Number could not be less than 0");
    }

    @Test
    public void whenNumberIsNegativeFiveThenException() {
        Factorial factorial = new Factorial();
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    factorial.calc(-5);
                });
        assertThat(exception.getMessage()).isEqualTo("Number could not be less than 0");
    }
}