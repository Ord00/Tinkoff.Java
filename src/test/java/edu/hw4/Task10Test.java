package edu.hw4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class Task10Test {
    @Test
    @DisplayName("Проверка вывода списка животных, возраст у которых не совпадает с количеством лап в корректном списке")
    void CorrectList() {
        ArrayList<Animal> list = new ArrayList<>();
        list.add(new Animal("Thunder", Animal.Type.DOG, Animal.Sex.M, 4, 35, 10, true));
        list.add(new Animal("Majesty", Animal.Type.FISH, Animal.Sex.F, 2, 3, 21, false));
        list.add(new Animal("Eagle", Animal.Type.BIRD, Animal.Sex.M, 10, 7, 9, false));
        list.add(new Animal("Mr. Cat", Animal.Type.CAT, Animal.Sex.M, 4, 89, 17, true));
        list.add(new Animal("Maven", Animal.Type.BIRD, Animal.Sex.M, 111, 78, 19, true));
        String actual = Task10.listOfAnimalsWithoutEqualAgeAndPaws(list).toString();
        String expected = "[Majesty, Eagle, Maven]";
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Проверка вывода списка животных, возраст у которых не совпадает с количеством лап на 'null' значении")
    void NullList() {
        assertThrows(NullPointerException.class, () -> Task10.listOfAnimalsWithoutEqualAgeAndPaws(null)).toString();
    }

    @Test
    @DisplayName("Проверка вывода списка животных, возраст у которых не совпадает с количеством лап на пустом списке")
    void EmptyList() {
        ArrayList<Animal> list = new ArrayList<>();
        String actual = Task10.listOfAnimalsWithoutEqualAgeAndPaws(list).toString();
        String expected = "[]";
        assertEquals(expected, actual);
    }
}
