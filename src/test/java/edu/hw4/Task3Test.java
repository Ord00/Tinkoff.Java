package edu.hw4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Task3Test {
    @Test
    @DisplayName("Проверка вывода кол-ва животных каждого вида с заполненным списком")
    void CorrectList() {
        ArrayList<Animal> list = new ArrayList<>();
        list.add(new Animal("Thunder", Animal.Type.DOG, Animal.Sex.M, 6, 35, 10, true));
        list.add(new Animal("Majesty", Animal.Type.FISH, Animal.Sex.F, 2, 3, 21, false));
        list.add(new Animal("Eagle", Animal.Type.BIRD, Animal.Sex.M, 10, 7, 9, false));
        list.add(new Animal("Mr. Cat", Animal.Type.CAT, Animal.Sex.M, 1, 89, 17, true));
        list.add(new Animal("Maven", Animal.Type.BIRD, Animal.Sex.M, 111, 78, 19, true));
        String actual = Task3.countAnimalType(list).toString();
        String expected = "{FISH=1, CAT=1, DOG=1, BIRD=2}";
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Проверка вывода кол-ва животных каждого вида на 'null' значении")
    void NullList() {
        assertThrows(NullPointerException.class, () -> Task3.countAnimalType(null).toString());
    }

    @Test
    @DisplayName("Проверка вывода кол-ва животных каждого вида на пустом списке")
    void EmptyList() {
        ArrayList<Animal> list = new ArrayList<>();
        String actual = Task3.countAnimalType(list).toString();
        String expected = "{}";
        assertEquals(expected, actual);
    }
}
