package edu.hw4;

import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Task15Test {
    @Test
    @DisplayName("Проверка суммарного веса животных каждого вида, которым от k до l лет, с заполненным списком и k < l")
    void CorrectListKLessThanL() {
        ArrayList<Animal> list = getAnimals();
        Map<Animal.Type, Long> actual = Task15.bitesAndHeightMoreThan100(list, 2, 6);
        Map<Animal.Type, Long> expected = new HashMap<>();
        expected.put(Animal.Type.DOG, 10L);
        expected.put(Animal.Type.FISH, 39L);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Проверка суммарного веса животных каждого вида, которым от k до l лет, с заполненным списком и k = l")
    void CorrectListKEqualsL() {
        ArrayList<Animal> list = getAnimals();
        Map<Animal.Type, Long> actual = Task15.bitesAndHeightMoreThan100(list, 6, 6);
        Map<Animal.Type, Long> expected = new HashMap<>();
        expected.put(Animal.Type.DOG, 10L);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Проверка суммарного веса животных каждого вида, которым от k до l лет, с заполненным списком и k > l")
    void CorrectListKMoreThanL() {
        ArrayList<Animal> list = getAnimals();
        assertThrows(NullPointerException.class, () -> Task15.bitesAndHeightMoreThan100(list, 6, 2).toString());
    }

    @NotNull private static ArrayList<Animal> getAnimals() {
        ArrayList<Animal> list = new ArrayList<>();
        list.add(new Animal("Murmur", Animal.Type.FISH, Animal.Sex.F, 1, 39, 8, false));
        list.add(new Animal("Thunder", Animal.Type.DOG, Animal.Sex.M, 6, 35, 10, true));
        list.add(new Animal("Maverlous", Animal.Type.FISH, Animal.Sex.F, 2, 3, 21, false));
        list.add(new Animal("Eagle", Animal.Type.BIRD, Animal.Sex.M, 10, 7, 9, false));
        list.add(new Animal("Mr. Cat", Animal.Type.CAT, Animal.Sex.M, 1, 89, 17, true));
        list.add(new Animal("Scratch", Animal.Type.FISH, Animal.Sex.M, 3, 1, 18, false));
        return list;
    }

    @Test
    @DisplayName("Проверка вывода самого тяжелого животного каждого вида на 'null' значении")
    void NullList() {
        assertThrows(NullPointerException.class, () -> Task15.bitesAndHeightMoreThan100(null, 0, 0).toString());
    }

    @Test
    @DisplayName("Проверка вывода самого тяжелого животного каждого вида на пустом списке")
    void EmptyList() {
        assertThrows(
            NullPointerException.class,
            () -> Task15.bitesAndHeightMoreThan100(new ArrayList<>(), 0, 5).toString()
        );
    }
}
