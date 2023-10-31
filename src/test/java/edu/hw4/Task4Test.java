package edu.hw4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Task4Test {
    @Test
    @DisplayName("Проверка вывода самого длинного имени с заполненным списком")
    void CorrectList() {
        ArrayList<Animal> list = new ArrayList<>();
        list.add(new Animal("Thunder", Animal.Type.DOG, Animal.Sex.M, 6, 35, 10, true));
        list.add(new Animal("Maverlous", Animal.Type.FISH, Animal.Sex.F, 2, 3, 21, false));
        list.add(new Animal("Eagle", Animal.Type.BIRD, Animal.Sex.M, 10, 7, 9, false));
        list.add(new Animal("Mr. Cat", Animal.Type.CAT, Animal.Sex.M, 1, 89, 17, true));
        String actual = Task4.theLongestName(list).toString();
        String expected = "Optional[Maverlous]";
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Проверка вывода самого длинного имени на 'null' значении")
    void NullList() {
        assertThrows(NullPointerException.class, () -> Task4.theLongestName(null).toString());
    }

    @Test
    @DisplayName("Проверка вывода самого длинного имени на пустом списке")
    void EmptyList() {
        ArrayList<Animal> list = new ArrayList<>();
        String actual = Task4.theLongestName(list).toString();
        String expected = "Optional.empty";
        assertEquals(expected, actual);
    }
}
