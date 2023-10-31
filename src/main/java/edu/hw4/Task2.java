package edu.hw4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Task2 {
    private Task2() {

    }

    static List<Animal> sortByWeight(List<Animal> animalList, Integer k) {
        if (animalList == null) {
            throw new NullPointerException();
        }
        if (k > 0) {
            int size = k > animalList.size() ? animalList.size() : k;
            return animalList.stream().sorted(Comparator.comparingInt(Animal::weight).reversed()).limit(size)
                .collect(Collectors.toList());
        }
        return new ArrayList<>();
    }
}
