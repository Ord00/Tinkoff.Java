package edu.hw4;

import java.util.ArrayList;
import java.util.List;

public class Task2 {
    private Task2() {

    }

    static List<Animal> sortByWeight(List<Animal> animalList, Integer k) {
        List<Animal> result = new ArrayList<>(animalList);
        if (k > 0) {
            int size = k > animalList.size() ? animalList.size() : k;
            result.subList(0, size).sort((o1, o2) -> {
                Integer h1 = o1.weight();
                Integer h2 = o2.weight();
                return h2.compareTo(h1);
            });
        }
        return result;
    }
}
