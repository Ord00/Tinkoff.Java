package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task2Test {

    @Test
    @DisplayName("Проверка положительного числа №1")
    void test1() {
        int actual = Task2.countDigits(1234);
        int expected = 4;
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Проверка отрицательного числа")
    void test3() {
        int actual = Task2.countDigits(-12134);
        int expected = 5;
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Проверка положительного числа №2")
    void test4() {
        int actual = Task2.countDigits(1211);
        int expected = 4;
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Проверка числа из примера №1")
    void test5() {
        int actual = Task2.countDigits(4666);
        int expected = 4;
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Проверка числа из примера №2")
    void test6() {
        int actual = Task2.countDigits(544);
        int expected = 3;
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Проверка числа из примера №3")
    void test7() {
        int actual = Task2.countDigits(0);
        int expected = 1;
        assertEquals(expected, actual);
    }
}
