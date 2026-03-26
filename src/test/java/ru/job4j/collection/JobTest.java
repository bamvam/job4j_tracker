package ru.job4j.collection;

import org.junit.jupiter.api.Test;
import java.util.Comparator;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class JobTest {
    @Test
    public void whenComparatorByNameAndPriority() {
        Comparator<Job> cmpNamePriority = new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenSortAscByName() {
        List<Job> jobs = new ArrayList<>();
        jobs.add(new Job("Zebra", 1));
        jobs.add(new Job("Apple", 2));
        jobs.add(new Job("Monkey", 3));

        Collections.sort(jobs, new JobAscByName());

        assertThat(jobs.get(0).getName()).isEqualTo("Apple");
        assertThat(jobs.get(1).getName()).isEqualTo("Monkey");
        assertThat(jobs.get(2).getName()).isEqualTo("Zebra");
    }

    @Test
    public void whenSortAscByPriority() {
        List<Job> jobs = new ArrayList<>();
        jobs.add(new Job("Task1", 3));
        jobs.add(new Job("Task2", 1));
        jobs.add(new Job("Task3", 2));

        Collections.sort(jobs, new JobAscByPriority());

        assertThat(jobs.get(0).getPriority()).isEqualTo(1);
        assertThat(jobs.get(1).getPriority()).isEqualTo(2);
        assertThat(jobs.get(2).getPriority()).isEqualTo(3);
    }

    @Test
    public void whenSortDescByName() {
        List<Job> jobs = new ArrayList<>();
        jobs.add(new Job("Apple", 1));
        jobs.add(new Job("Zebra", 2));
        jobs.add(new Job("Monkey", 3));

        Collections.sort(jobs, new JobDescByName());

        assertThat(jobs.get(0).getName()).isEqualTo("Zebra");
        assertThat(jobs.get(1).getName()).isEqualTo("Monkey");
        assertThat(jobs.get(2).getName()).isEqualTo("Apple");
    }

    @Test
    public void whenSortDescByPriority() {
        List<Job> jobs = new ArrayList<>();
        jobs.add(new Job("Task1", 1));
        jobs.add(new Job("Task2", 3));
        jobs.add(new Job("Task3", 2));

        Collections.sort(jobs, new JobDescByPriority());

        assertThat(jobs.get(0).getPriority()).isEqualTo(3);
        assertThat(jobs.get(1).getPriority()).isEqualTo(2);
        assertThat(jobs.get(2).getPriority()).isEqualTo(1);
    }

    // === Тесты комбинированных компараторов ===

    @Test
    public void whenComparatorByNameAndPriorityAsc() {
        Comparator<Job> combined = new JobAscByName()
                .thenComparing(new JobAscByPriority());

        int result = combined.compare(
                new Job("Fix bug", 2),
                new Job("Fix bug", 1)
        );
        // Имена равны → сравниваем приоритет: 2 > 1 → результат > 0
        assertThat(result).isGreaterThan(0);
    }

    @Test
    public void whenComparatorByNameDescAndPriorityAsc() {
        Comparator<Job> combined = new JobDescByName()
                .thenComparing(new JobAscByPriority());

        int result = combined.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        // "Impl task" > "Fix bug" по убыванию → результат < 0
        assertThat(result).isLessThan(0);
    }

    @Test
    public void whenComparatorByNameAscAndPriorityDesc() {
        Comparator<Job> combined = new JobAscByName()
                .thenComparing(new JobDescByPriority());

        List<Job> jobs = new ArrayList<>();
        jobs.add(new Job("Fix bug", 1));
        jobs.add(new Job("Fix bug", 4));
        jobs.add(new Job("Fix bug", 2));
        jobs.add(new Job("X task", 0));

        Collections.sort(jobs, combined);

        // Сначала "Fix bug" (по имени), внутри — по приоритету убывание: 4, 2, 1
        assertThat(jobs.get(0)).isEqualTo(new Job("Fix bug", 4));
        assertThat(jobs.get(1)).isEqualTo(new Job("Fix bug", 2));
        assertThat(jobs.get(2)).isEqualTo(new Job("Fix bug", 1));
        assertThat(jobs.get(3)).isEqualTo(new Job("X task", 0));
    }

    @Test
    public void whenComparatorDescByNameAndDescByPriority() {
        Comparator<Job> combined = new JobDescByName()
                .thenComparing(new JobDescByPriority());

        int result = combined.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        // "Impl task" > "Fix bug" по убыванию → результат < 0
        assertThat(result).isLessThan(0);
    }

    @Test
    public void whenComparatorChainOfThree() {
        // Комбинация трёх компараторов (пример из задания)
        Comparator<Job> combined = new JobAscByName()
                .thenComparing(new JobAscByPriority())
                .thenComparing(Comparator.comparingInt(Job::getPriority));

        // Проверяем, что цепочка работает
        int result = combined.compare(
                new Job("Task", 5),
                new Job("Task", 5)
        );
        assertThat(result).isEqualTo(0);
    }
}