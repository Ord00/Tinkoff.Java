package edu.hw4;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Task7 {
    private Task7() {

    }

    public static Optional<Animal> theKEldestAnimal(List<Animal> animalList, Integer k) {
        if (animalList.isEmpty() || k < 0 || k > animalList.size()) {
            return null;
        }
        return animalList.stream().sorted(Comparator.comparingInt(Animal::age)).skip(k - 1).findFirst();
    }
}
