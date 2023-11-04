package edu.hw4;

import java.util.List;

public class Task11 {
    private Task11() {

    }

    final static int MIN_HEIGHT = 100;

    public static List<Animal> bitesAndHeightMoreThan100(List<Animal> animalList) {
        return animalList.stream().filter(i -> i.bites() && i.height() > MIN_HEIGHT).toList();
    }
}
