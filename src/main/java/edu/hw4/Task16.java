package edu.hw4;

import java.util.Comparator;
import java.util.List;

public class Task16 {
    private Task16() {

    }
    public static List<Animal> sortTypeThenSexThenName(List<Animal> animalList) {
        Comparator<Animal> animalComparator = Comparator.comparing(Animal::type).
            thenComparing(Animal::sex).
            thenComparing(Animal::name);
        return animalList.stream().sorted(animalComparator).toList();
    }
}
