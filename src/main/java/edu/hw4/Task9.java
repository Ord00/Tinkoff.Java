package edu.hw4;

import java.util.List;

public class Task9 {
    private Task9() {

    }
    public static Integer sumOfPaws(List<Animal> animalList) {
        return animalList.stream().mapToInt(Animal::paws).sum();
    }
}
