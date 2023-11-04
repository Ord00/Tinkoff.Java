package edu.hw4;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Task8 {
    private Task8() {

    }

    public static Optional<Animal> TheHeaviestAnimalBelowKHeight(List<Animal> animalList, Integer k) {
        return animalList.stream().filter(i -> i.height() < k).max(Comparator.comparingInt(Animal::weight));
    }
}
