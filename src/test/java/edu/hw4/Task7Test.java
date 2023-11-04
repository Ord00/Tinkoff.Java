package edu.hw4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class Task7Test {
    @Test
    @DisplayName("Проверка вывода K-го самого старого животного с заполненным списком и корректным K")
    void CorrectListAndCorrectK() {
        ArrayList<Animal> list = new ArrayList<>();
        list.add(new Animal("Thunder", Animal.Type.DOG, Animal.Sex.M, 6, 35, 10, true));
        list.add(new Animal("Majesty", Animal.Type.FISH, Animal.Sex.F, 2, 3, 21, false));
        list.add(new Animal("Eagle", Animal.Type.BIRD, Animal.Sex.M, 10, 7, 9, false));
        list.add(new Animal("Mr. Cat", Animal.Type.CAT, Animal.Sex.M, 1, 89, 17, true));
        list.add(new Animal("Maven", Animal.Type.BIRD, Animal.Sex.M, 111, 78, 19, true));
        String actual = Task7.theKEldestAnimal(list, 3).toString();
        String expected = "Optional[Thunder]";
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName(
        "Проверка вывода K-го самого старого животного с заполненным списком и K, превышающим кол-во элементов в списке")
    void CorrectListAndOversizeK() {
        ArrayList<Animal> list = new ArrayList<>();
        list.add(new Animal("Thunder", Animal.Type.DOG, Animal.Sex.M, 6, 35, 10, true));
        list.add(new Animal("Majesty", Animal.Type.FISH, Animal.Sex.F, 2, 3, 21, false));
        list.add(new Animal("Eagle", Animal.Type.BIRD, Animal.Sex.M, 10, 7, 9, false));
        list.add(new Animal("Mr. Cat", Animal.Type.CAT, Animal.Sex.M, 1, 89, 17, true));
        list.add(new Animal("Maven", Animal.Type.BIRD, Animal.Sex.M, 111, 78, 19, true));
        Optional<Animal> actual = Task7.theKEldestAnimal(list, 10);
        assertNull(actual);
    }

    @Test
    @DisplayName("Проверка вывода K-го самого старого животного с заполненным списком и отрицательным K")
    void CorrectListAndNegativeK() {
        ArrayList<Animal> list = new ArrayList<>();
        list.add(new Animal("Thunder", Animal.Type.DOG, Animal.Sex.M, 6, 35, 10, true));
        list.add(new Animal("Majesty", Animal.Type.FISH, Animal.Sex.F, 2, 3, 21, false));
        list.add(new Animal("Eagle", Animal.Type.BIRD, Animal.Sex.M, 10, 7, 9, false));
        list.add(new Animal("Mr. Cat", Animal.Type.CAT, Animal.Sex.M, 1, 89, 17, true));
        list.add(new Animal("Maven", Animal.Type.BIRD, Animal.Sex.M, 111, 78, 19, true));
        Optional<Animal> actual = Task7.theKEldestAnimal(list, -10);
        assertNull(actual);
    }

    @Test
    @DisplayName("Проверка вывода K-го самого старого животного на 'null' значении")
    void NullList() {
        assertThrows(NullPointerException.class, () -> Task7.theKEldestAnimal(null, 0).toString());
    }

    @Test
    @DisplayName("Проверка вывода кол-ва животных каждого вида на пустом списке")
    void EmptyList() {
        ArrayList<Animal> list = new ArrayList<>();
        Optional<Animal> actual = Task7.theKEldestAnimal(list, 0);
        assertNull(actual);
    }
}
