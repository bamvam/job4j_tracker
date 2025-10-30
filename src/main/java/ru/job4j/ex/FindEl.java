package ru.job4j.ex;

public class FindEl {
    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        for (int i = 0; i < value.length; i++) {
            if (key.equals(value[i])) {
                return i;
            }
        }
        throw new ElementNotFoundException("Element '" + key + "' not found in array");
    }

    public static void main(String[] args) {
        String[] names = {"Petr", "Ivan", "Nik", "Vasya"};

        try {
            int index1 = indexOf(names, "Ivan");
            System.out.println("Index of 'Ivan': " + index1);

            int index2 = indexOf(names, "Oleg");
            System.out.println("Index of 'Oleg': " + index2);

        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }

        try {
            int index3 = indexOf(names, "Petr");
            System.out.println("Index of 'Petr': " + index3);
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }
}
