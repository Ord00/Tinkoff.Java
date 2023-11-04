package edu.hw4;

import edu.hw4.Validation.Task19;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Task19Test {
    @Test
    @DisplayName("Проверка поиска ошибок в корректном списке")
    void CorrectList() {
        ArrayList<Animal> list = new ArrayList<>();
        list.add(new Animal("Eagle", Animal.Type.BIRD, Animal.Sex.F, 10, 7, -9, false));
        list.add(new Animal("Maven", Animal.Type.BIRD, Animal.Sex.M, 111, 78, 19, true));
        list.add(new Animal("Frog", Animal.Type.BIRD, Animal.Sex.F, 10, 7, 9, false));
        list.add(new Animal("Majesty", Animal.Type.FISH, Animal.Sex.F, 2, 3, 21, false));
        list.add(new Animal("Thunder", Animal.Type.FISH, Animal.Sex.F, 4, 235, 10, true));
        list.add(new Animal("Mysterio", Animal.Type.FISH, Animal.Sex.M, 4, 189, 17, true));
        String actual = Task19.errorsInRecords(list).toString();
        actual = actual.substring(0, actual.length() - 11) + actual.substring(actual.length() - 2);
        String expected = "{Eagle=[edu.hw4.Validation.ValidationError]}";
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Проверка поиска ошибок на 'null' значении")
    void NullList() {
        assertThrows(NullPointerException.class, () -> Task19.errorsInRecords(null)).toString();
    }

    @Test
    @DisplayName("Проверка поиска ошибок на пустом списке")
    void EmptyList() {
        List<Animal> list = new ArrayList<>();
        assertThrows(NullPointerException.class, () -> Task19.errorsInRecords(list)).toString();
    }
}
