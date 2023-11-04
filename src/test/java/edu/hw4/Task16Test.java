package edu.hw4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class Task16Test {
    @Test
    @DisplayName("Проверка списка животных, отсортированного по виду, затем по полу, затем по имени, в корректном списке")
    void CorrectList() {
        ArrayList<Animal> list = new ArrayList<>();
        list.add(new Animal("Eagle", Animal.Type.BIRD, Animal.Sex.F, 10, 7, 9, false));
        list.add(new Animal("Maven", Animal.Type.BIRD, Animal.Sex.M, 111, 78, 19, true));
        list.add(new Animal("Frog", Animal.Type.BIRD, Animal.Sex.F, 10, 7, 9, false));
        list.add(new Animal("Majesty", Animal.Type.FISH, Animal.Sex.M, 2, 3, 21, false));
        list.add(new Animal("Thunder", Animal.Type.FISH, Animal.Sex.F, 4, 235, 10, true));
        list.add(new Animal("Mr. Cat", Animal.Type.FISH, Animal.Sex.M, 4, 189, 17, true));
        String actual = Task16.sortTypeThenSexThenName(list).toString();
        String expected = "[Maven, Eagle, Frog, Majesty, Mr. Cat, Thunder]";
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Проверка списка животных, отсортированного по виду, затем по полу, затем по имени, на 'null' значении")
    void NullList() {
        assertThrows(NullPointerException.class, () -> Task16.sortTypeThenSexThenName(null)).toString();
    }

    @Test
    @DisplayName("Проверка списка животных, отсортированного по виду, затем по полу, затем по имени, на пустом списке")
    void EmptyList() {
        ArrayList<Animal> list = new ArrayList<>();
        String actual = Task16.sortTypeThenSexThenName(list).toString();
        String expected = "[]";
        assertEquals(expected, actual);
    }
}

