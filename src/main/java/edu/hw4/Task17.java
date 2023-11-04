package edu.hw4;

import java.util.List;

public class Task17 {
    private Task17() {

    }

    public static Boolean isSpidersBiteMoreThanDogs(List<Animal> animalList) {
        if (animalList.stream().filter(i -> i.type().equals(Animal.Type.SPIDER)).count() == 0
            || animalList.stream().filter(i -> i.type().equals(Animal.Type.DOG)).count() == 0) {
            return false;
        }
        return animalList.stream().filter(i -> i.type().equals(Animal.Type.SPIDER) && i.bites()).count()
            > animalList.stream().filter(i -> i.type().equals(Animal.Type.DOG) && i.bites()).count();
    }
}
