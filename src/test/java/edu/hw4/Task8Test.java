package edu.hw4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class Task8Test {
    @Test
    @DisplayName("Проверка вывода самого тяжелого животного среди животных ниже k см, где таких животных нет")
    void CorrectListAndUnreachableK() {
        ArrayList<Animal> list = new ArrayList<>();
        list.add(new Animal("Thunder", Animal.Type.DOG, Animal.Sex.M, 6, 35, 10, true));
        list.add(new Animal("Majesty", Animal.Type.FISH, Animal.Sex.F, 2, 3, 21, false));
        list.add(new Animal("Eagle", Animal.Type.BIRD, Animal.Sex.M, 10, 7, 9, false));
        list.add(new Animal("Mr. Cat", Animal.Type.CAT, Animal.Sex.M, 1, 89, 17, true));
        list.add(new Animal("Maven", Animal.Type.BIRD, Animal.Sex.M, 111, 78, 19, true));
        String actual = Task8.TheHeaviestAnimalBelowKHeight(list, 3).toString();
        String expected = "Optional.empty";
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Проверка вывода самого тяжелого животного среди животных ниже k см, где такие животные есть")
    void CorrectListAndReachableK() {
        ArrayList<Animal> list = new ArrayList<>();
        list.add(new Animal("Thunder", Animal.Type.DOG, Animal.Sex.M, 6, 35, 10, true));
        list.add(new Animal("Majesty", Animal.Type.FISH, Animal.Sex.F, 2, 3, 21, false));
        list.add(new Animal("Eagle", Animal.Type.BIRD, Animal.Sex.M, 10, 7, 9, false));
        list.add(new Animal("Mr. Cat", Animal.Type.CAT, Animal.Sex.M, 1, 89, 17, true));
        list.add(new Animal("Maven", Animal.Type.BIRD, Animal.Sex.M, 111, 78, 19, true));
        String actual = Task8.TheHeaviestAnimalBelowKHeight(list, 50).toString();
        String expected = "Optional[Majesty]";
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Проверка вывода самого тяжелого животного среди животных ниже k см на 'null' значении")
    void NullList() {
        assertThrows(NullPointerException.class, () -> Task8.TheHeaviestAnimalBelowKHeight(null, 0).toString());
    }

    @Test
    @DisplayName("Проверка вывода самого тяжелого животного среди животных ниже k см на пустом списке")
    void EmptyList() {
        ArrayList<Animal> list = new ArrayList<>();
        String actual = Task8.TheHeaviestAnimalBelowKHeight(list, 0).toString();
        String expected = "Optional.empty";
        assertEquals(expected, actual);
    }
}
