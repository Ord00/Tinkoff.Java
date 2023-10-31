package edu.hw4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Task5Test {
    @Test
    @DisplayName("Проверка вывода самого длинного имени с заполненным списком")
    void CorrectList() {
        ArrayList<Animal> list = new ArrayList<>();
        list.add(new Animal("Thunder", Animal.Type.DOG, Animal.Sex.M, 6, 35, 10, true));
        list.add(new Animal("Maverlous", Animal.Type.FISH, Animal.Sex.F, 2, 3, 21, false));
        list.add(new Animal("Eagle", Animal.Type.BIRD, Animal.Sex.M, 10, 7, 9, false));
        list.add(new Animal("Mr. Cat", Animal.Type.CAT, Animal.Sex.M, 1, 89, 17, true));
        String actual = Task5.moreCommonSex(list).toString();
        String expected = "M";
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Проверка вывода самого длинного имени на 'null' значении")
    void NullList() {
        assertThrows(NullPointerException.class, () -> Task5.moreCommonSex(null).toString());
    }

    @Test
    @DisplayName("Проверка вывода самого длинного имени на пустом списке")
    void EmptyList() {
        assertThrows(NullPointerException.class, () -> Task5.moreCommonSex(new ArrayList<>()).toString());
    }
}
