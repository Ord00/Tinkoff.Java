package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task6Test {

    @Test
    @DisplayName("Проверка числа из примера №1")
    void test1() {
        int actual = Task6.countK(6621);
        int expected = 5;
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Проверка числа из примера №2")
    void test2() {
        int actual = Task6.countK(6554);
        int expected = 4;
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Проверка числа из примера №3")
    void test3() {
        int actual = Task6.countK(1234);
        int expected = 3;
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Проверка четного числа")
    void test4() {
        int actual = Task6.countK(3524);
        int expected = 3;
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Проверка нечетного числа")
    void test5() {
        int actual = Task6.countK(1121);
        int expected = 5;
        assertEquals(expected, actual);
    }
}
