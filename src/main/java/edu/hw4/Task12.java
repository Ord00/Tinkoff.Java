package edu.hw4;

import java.util.List;

public class Task12 {
    private Task12() {

    }
    public static Integer weightMoreHeight(List<Animal> animalList) {
        return Math.toIntExact(animalList.stream().filter(i -> i.weight() > i.height()).count());
    }
}
