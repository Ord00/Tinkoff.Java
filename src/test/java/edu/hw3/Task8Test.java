package edu.hw3;

import edu.hw3.Task8.BackwardIterator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Task8Test {
    @Test
    @DisplayName("Проверка итераторатора на листе [1, 2, 3]")
    void checkComp1() {
        BackwardIterator iterator = new BackwardIterator(Integer.class, (List.of(1, 2, 3)));
        String actual = iterator.toString();
        String expected = "[3, 2, 1]";
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Проверка итераторатора на листе [78.34, 9.6, 55.178]")
    void checkComp2() {
        BackwardIterator iterator = new BackwardIterator(Double.class, (List.of(78.34, 9.6, 55.178)));
        String actual = iterator.toString();
        String expected = "[55.178, 9.6, 78.34]";
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Проверка итераторатора на листе ['a', 'b', 'c', 'd']")
    void checkComp3() {
        BackwardIterator iterator = new BackwardIterator(Character.class, (List.of('a', 'b', 'c', 'd')));
        String actual = iterator.toString();
        String expected = "[d, c, b, a]";
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Проверка итераторатора на пустом листе")
    void checkEmpty() {
        BackwardIterator iterator = new BackwardIterator(Double.class, List.of());
        String actual = iterator.toString();
        String expected = "[]";
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Проверка итераторатора на \"null\" ")
    void checkNull() {
        assertThrows(NullPointerException.class, () -> new BackwardIterator(NullPointerException.class, null));
    }
}
