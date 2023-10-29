package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task7Test {

    @Test
    @DisplayName("Проверка примера №2")
    void test1() {
        int actual = Task7.rotateLeft(16, 1);
        int expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Проверка примера №3")
    void test2() {
        int actual = Task7.rotateLeft(17, 2);
        int expected = 6;
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Проверка отрицательного сдвига")
    void test3() {
        int actual = Task7.rotateLeft(21, -2);
        int expected = 13;
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Проверка 0-го сдвига")
    void test4() {
        int actual = Task7.rotateLeft(17, 0);
        int expected = 17;
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Проверка отрицательного числа")
    void test5() {
        int actual = Task7.rotateLeft(-22, 2);
        int expected = -1;
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Проверка примера №1")
    void test6() {
        int actual = Task7.rotateRight(8, 1);
        int expected = 4;
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Проверка примера №3")
    void test7() {
        int actual = Task7.rotateRight(17, 2);
        int expected = 12;
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Проверка сдвига на 2 позиции")
    void test8() {
        int actual = Task7.rotateRight(21, 2);
        int expected = 13;
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Проверка 0-го сдвига")
    void test9() {
        int actual = Task7.rotateRight(17, 0);
        int expected = 17;
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Проверка отрицательного числа")
    void test10() {
        int actual = Task7.rotateRight(-22, 2);
        int expected = -1;
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Проверка отрицательного сдвига")
    void test11() {
        int actual = Task7.rotateRight(21, -2);
        int expected = 22;
        assertEquals(expected, actual);
    }
}
