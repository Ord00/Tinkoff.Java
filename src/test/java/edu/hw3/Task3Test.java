package edu.hw3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task3Test {
    @Test
    @DisplayName("Проверка примера №1")
    void test1() {
        List<Object> list = Arrays.asList("a", "bb", "a", "bb");
        String actual = Task3.freqDict(list);
        String expected = "{bb: 2, a: 2}";
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Проверка примера №2")
    void test2() {
        List<Object> list = Arrays.asList("this", "and", "that", "and");
        String actual = Task3.freqDict(list);
        String expected = "{that: 1, and: 2, this: 1}";
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Проверка примера №3")
    void test3() {
        List<Object> list = Arrays.asList("код", "код", "код", "bug");
        String actual = Task3.freqDict(list);
        String expected = "{код: 3, bug: 1}";
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Проверка примера №4")
    void test4() {
        List<Object> list = Arrays.asList(1, 1, 2, 2);
        String actual = Task3.freqDict(list);
        String expected = "{1: 2, 2: 2}";
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Проверка строк из пробелов")
    void test5() {
        List<Object> list = Arrays.asList("  ", "  ", " ", " ", "  ");
        String actual = Task3.freqDict(list);
        String expected = "{  : 3,  : 2}";
        assertEquals(expected, actual);
    }
}
