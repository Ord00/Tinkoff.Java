package edu.hw4;

import java.util.List;

public class Task5 {
    private Task5() {

    }

    static Animal.Sex moreCommonSex(List<Animal> animalList) {
        if (animalList.isEmpty()) {
            return null;
        }
        if (animalList.stream().filter(i -> i.sex().equals(Animal.Sex.M)).count()
            > animalList.stream().filter(i -> i.sex().equals(Animal.Sex.F)).count()) {
            return Animal.Sex.M;
        }
        return Animal.Sex.F;
    }
}
