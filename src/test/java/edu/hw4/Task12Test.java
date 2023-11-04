package edu.hw4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class Task12Test {
    @Test
    @DisplayName("Проверка кол-ва животных, вес которых превышает рост, в корректном списке")
    void CorrectList() {
        ArrayList<Animal> list = new ArrayList<>();
        list.add(new Animal("Thunder", Animal.Type.DOG, Animal.Sex.M, 4, 235, 10, true));
        list.add(new Animal("Majesty", Animal.Type.FISH, Animal.Sex.F, 2, 3, 21, false));
        list.add(new Animal("Eagle", Animal.Type.BIRD, Animal.Sex.M, 10, 7, 9, false));
        list.add(new Animal("Mr. Cat", Animal.Type.CAT, Animal.Sex.M, 4, 189, 17, true));
        list.add(new Animal("Maven", Animal.Type.BIRD, Animal.Sex.M, 111, 78, 19, true));
        Integer actual = Task12.weightMoreHeight(list);
        Integer expected = 2;
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Проверка кол-ва животных, вес которых превышает рост, на 'null' значении")
    void NullList() {
        assertThrows(NullPointerException.class, () -> Task12.weightMoreHeight(null));
    }

    @Test
    @DisplayName("Проверка кол-ва животных, вес которых превышает рост, на пустом списке")
    void EmptyList() {
        ArrayList<Animal> list = new ArrayList<>();
        Integer actual = Task12.weightMoreHeight(list);
        Integer expected = 0;
        assertEquals(expected, actual);
    }
}