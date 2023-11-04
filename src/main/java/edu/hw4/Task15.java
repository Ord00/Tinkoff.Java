package edu.hw4;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Task15 {
    private Task15() {

    }

    public static Map<Animal.Type, Long> bitesAndHeightMoreThan100(List<Animal> animalList, Integer k, Integer l) {
        return animalList.stream()
            .filter(i -> i.age() >= k && i.age() <= l)
            .collect(Collectors.groupingBy(Animal::type, Collectors.summingLong(Animal::weight)));
    }
}
