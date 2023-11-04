package edu.hw4;

import java.util.List;

public class Task14 {
    private Task14() {

    }
    public static Boolean checkDogOfMoreThanKHeight(List<Animal> animalList, Integer k) {
        return animalList.stream().anyMatch(i -> i.type().equals(Animal.Type.DOG) && i.height() > k);
    }
}
