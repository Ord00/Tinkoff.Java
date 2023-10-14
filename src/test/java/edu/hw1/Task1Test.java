package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task1Test {
    @Test
    @DisplayName("Проверка с отстуствием минут")
    void test1() {
        int actual = Task1.minutesToSeconds(":11");
        int expected = -1;
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Проверка с отстуствием секунд")
    void test2() {
        int actual = Task1.minutesToSeconds("12341:");
        int expected = -1;
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Проверка с отрицательными минутами")
    void test3() {
        int actual = Task1.minutesToSeconds("-88:11");
        int expected = -1;
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Проверка отсутствия ':'")
    void test4() {
        int actual = Task1.minutesToSeconds("1289");
        int expected = -1;
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Проверка с буквами вместо цифр")
    void test5() {
        int actual = Task1.minutesToSeconds("ab:cd");
        int expected = -1;
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Проверка с двумя ':'")
    void test6() {
        int actual = Task1.minutesToSeconds(":9:");
        int expected = -1;
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Проверка пустой строки")
    void test7() {
        int actual = Task1.minutesToSeconds("");
        int expected = -1;
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Проверка корректных данных")
    void test8() {
        int actual = Task1.minutesToSeconds("12:11");
        int expected = 731;
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Проверка вышедших за диапазон секунд")
    void test9() {
        int actual = Task1.minutesToSeconds("12:61");
        int expected = -1;
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Проверка строки из примера №1")
    void test10() {
        int actual = Task1.minutesToSeconds("1:00");
        int expected = 60;
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Проверка строки из примера №2")
    void test11() {
        int actual = Task1.minutesToSeconds("13:56");
        int expected = 836;
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Проверка строки из примера №3")
    void test12() {
        int actual = Task1.minutesToSeconds("10:60");
        int expected = -1;
        assertEquals(expected, actual);
    }
}
