package edu.hw4;

import java.util.List;
import java.util.Optional;

public class Task4 {
    private Task4() {

    }

    static Optional<Animal> theLongestName(List<Animal> animalList) {
        return animalList.stream().max((o1, o2) -> {
            Integer l1 = o1.name().length();
            Integer l2 = o2.name().length();
            return l1.compareTo(l2);
        });
    }
}
