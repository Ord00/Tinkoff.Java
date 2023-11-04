package edu.hw4;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Task18 {
    private Task18() {

    }

    public static Optional<Animal> theHeaviestFish(List<List<Animal>> animalLists) {
        if (animalLists.size() < 2) {
            throw new NullPointerException();
        }
        return animalLists.stream().flatMap(List::stream)
            .filter(i -> i.type().equals(Animal.Type.FISH))
            .max(Comparator.comparing(Animal::weight));
    }
}
