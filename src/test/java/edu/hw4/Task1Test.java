package edu.hw4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Task1Test {
    @Test
    @DisplayName("Проверка сортировки по росту с заполненным списком")
    void СorrectList() {
        ArrayList<Animal> list = new ArrayList<>();
        list.add(new Animal("Thunder", Animal.Type.DOG, Animal.Sex.M, 6, 35, 10, true));
        list.add(new Animal("Eagle", Animal.Type.BIRD, Animal.Sex.M, 10, 7, 9, false));
        list.add(new Animal("Mr. Cat", Animal.Type.CAT, Animal.Sex.M, 1, 89, 17, true));
        String actual = Task1.sortByHeight(list).toString();
        String expected = "[Eagle, Thunder, Mr. Cat]";
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Проверка сортировки по росту на 'null' значении")
    void NullList() {
        assertThrows(NullPointerException.class, () -> Task1.sortByHeight(null).toString());
    }

    @Test
    @DisplayName("Проверка сортировки по росту на пустом списке")
    void EmptyList() {
        ArrayList<Animal> list = new ArrayList<>();
        String actual = Task1.sortByHeight(list).toString();
        String expected = "[]";
        assertEquals(expected, actual);
    }
}
