package edu.hw4;

import java.util.List;

public class Task10 {
    private Task10() {

    }

    public static List<Animal> listOfAnimalsWithoutEqualAgeAndPaws(List<Animal> animalList) {
        return animalList.stream().filter(i -> i.age() != i.paws()).toList();
    }
}
