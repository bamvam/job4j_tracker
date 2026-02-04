package ru.job4j.search;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.assertj.core.api.Assertions.assertThat;

public class PhoneDictionaryTest {

    @Test
    public void whenFindByName() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk")
        );
        ArrayList<Person> persons = phones.find("Petr");
        assertThat(persons.get(0).getSurname()).isEqualTo("Arsentev");
    }

    @Test
    public void whenFindByKeyInAnyField() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk")
        );

        ArrayList<Person> persons = phones.find("ns");
        assertThat(persons).hasSize(1);
        assertThat(persons.get(0).getSurname()).isEqualTo("Arsentev");

        persons = phones.find("534");
        assertThat(persons).hasSize(1);
        assertThat(persons.get(0).getSurname()).isEqualTo("Arsentev");

        persons = phones.find("Ars");
        assertThat(persons).hasSize(1);
        assertThat(persons.get(0).getSurname()).isEqualTo("Arsentev");
    }

    @Test
    public void whenNotFound() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk")
        );
        phones.add(
                new Person("Ivan", "Ivanov", "123456", "Moscow")
        );

        ArrayList<Person> persons = phones.find("Vasya");
        assertThat(persons).isEmpty();

        persons = phones.find("Saint");
        assertThat(persons).isEmpty();
    }

    @Test
    public void whenFindMultiplePersons() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(new Person("Petr", "Arsentev", "534872", "Bryansk"));
        phones.add(new Person("Ivan", "Petrov", "111111", "Saint-Petersburg"));
        phones.add(new Person("Sergey", "Ivanov", "222222", "Moscow"));

        ArrayList<Person> persons = phones.find("Petr");
        assertThat(persons).hasSize(2);
        assertThat(persons.get(0).getName()).isEqualTo("Petr");
        assertThat(persons.get(1).getSurname()).isEqualTo("Petrov");
    }
}