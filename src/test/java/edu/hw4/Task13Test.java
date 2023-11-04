package edu.hw4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class Task13Test {
    @Test
    @DisplayName("Проверка списка животных, имена которых состоят из более чем двух слов, в корректном списке")
    void CorrectList() {
        ArrayList<Animal> list = new ArrayList<>();
        list.add(new Animal("Majesty in the aquarium", Animal.Type.FISH, Animal.Sex.F, 2, 3, 21, false));
        list.add(new Animal("Eagle", Animal.Type.BIRD, Animal.Sex.M, 10, 7, 9, false));
        list.add(new Animal("Thunder and lightning", Animal.Type.DOG, Animal.Sex.M, 4, 235, 10, true));
        list.add(new Animal("Mr. Cat", Animal.Type.CAT, Animal.Sex.M, 4, 189, 17, true));
        list.add(new Animal("Maven", Animal.Type.BIRD, Animal.Sex.M, 111, 78, 19, true));
        String actual = Task13.weightMoreHeight(list).toString();
        String expected = "[Majesty in the aquarium, Thunder and lightning]";
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Проверка списка животных, имена которых состоят из более чем двух слов, на 'null' значении")
    void NullList() {
        assertThrows(NullPointerException.class, () -> Task13.weightMoreHeight(null)).toString();
    }

    @Test
    @DisplayName("Проверка списка животных, имена которых состоят из более чем двух слов, на пустом списке")
    void EmptyList() {
        ArrayList<Animal> list = new ArrayList<>();
        String actual = Task13.weightMoreHeight(list).toString();
        String expected = "[]";
        assertEquals(expected, actual);
    }
}
