package edu.hw4;

import java.util.ArrayList;
import java.util.List;

public class Task1 {
    private Task1() {

    }

    static List<Animal> sortByHeight(List<Animal> animalList) {
        List<Animal> result = new ArrayList<>(animalList);
        result.sort(((o1, o2) -> {
            Integer h1 = o1.height();
            Integer h2 = o2.height();
            return h1.compareTo(h2);
        }));
        return result;
    }
}
