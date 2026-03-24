package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ItemTest {

    @Test
    public void whenSortItemAscByName() {
        List<Item> items = new ArrayList<>();
        items.add(new Item("Zebra"));
        items.add(new Item("Apple"));
        items.add(new Item("Monkey"));

        Collections.sort(items, new ItemAscByName());

        List<Item> expected = new ArrayList<>();
        expected.add(new Item("Apple"));
        expected.add(new Item("Monkey"));
        expected.add(new Item("Zebra"));

        assertThat(items).isEqualTo(expected);
    }

    @Test
    public void whenSortItemDescByName() {
        List<Item> items = new ArrayList<>();
        items.add(new Item("Apple"));
        items.add(new Item("Zebra"));
        items.add(new Item("Monkey"));

        Collections.sort(items, new ItemDescByName());

        List<Item> expected = new ArrayList<>();
        expected.add(new Item("Zebra"));
        expected.add(new Item("Monkey"));
        expected.add(new Item("Apple"));

        assertThat(items).isEqualTo(expected);
    }
}