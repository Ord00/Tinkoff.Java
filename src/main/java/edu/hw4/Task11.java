package edu.hw4;

import java.util.List;

public class Task11 {
    private Task11() {

    }

    public static List<Animal> bitesAndHeightMoreThan100(List<Animal> animalList) {
        return animalList.stream().filter(i -> i.bites() && i.height() > 100).toList();
    }
}
