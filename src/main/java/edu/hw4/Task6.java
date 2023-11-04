package edu.hw4;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Task6 {
    private Task6() {

    }

    static Map<Animal.Type, Optional<Animal>> theHeaviestAnimalsOfEveryType(List<Animal> animalList) {
        if (animalList.isEmpty()) {
            return null;
        }
        return animalList.stream()
            .collect(Collectors.groupingBy(Animal::type, Collectors.maxBy(Comparator.comparing(Animal::weight))));
    }
}
