package ru.job4j.tracker;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class ValidateInputTest {

    @Test
    void whenInvalidInput() {
        Output output = new StubOutput();
        Input in = new MockInput(new String[] {"one", "1"});
        ValidateInput input = new ValidateInput(output, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(1);
    }

    @Test
    void whenValidInput() {
        Output output = new StubOutput();
        Input in = new MockInput(new String[] {"5"});
        ValidateInput input = new ValidateInput(output, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(5);
    }

    @Test
    void whenMultipleValidInput() {
        Output output = new StubOutput();
        Input in = new MockInput(new String[] {"1", "3", "7"});
        ValidateInput input = new ValidateInput(output, in);

        int first = input.askInt("Enter menu:");
        assertThat(first).isEqualTo(1);

        int second = input.askInt("Enter menu:");
        assertThat(second).isEqualTo(3);

        int third = input.askInt("Enter menu:");
        assertThat(third).isEqualTo(7);
    }

    @Test
    void whenNegativeInput() {
        Output output = new StubOutput();
        Input in = new MockInput(new String[] {"-5"});
        ValidateInput input = new ValidateInput(output, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(-5);
    }
}