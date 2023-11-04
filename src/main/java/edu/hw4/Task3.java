package edu.hw4;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Task3 {
    private Task3() {

    }

    static Map<Animal.Type, Long> countAnimalType(List<Animal> animalList) {
        return animalList.stream().collect(Collectors.groupingBy(Animal::type, Collectors.counting()));
    }
}
