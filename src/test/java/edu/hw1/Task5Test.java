package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Task5Test {

    @Test
    @DisplayName("Проверка потомка на полиндром №1")
    void test1() {
        boolean actual = Task5.isPalindromeDescendant(123456);
        boolean expected = false;
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Проверка потомка на полиндром №2")
    void test2() {
        boolean actual = Task5.isPalindromeDescendant(567879790);
        boolean expected = false;
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Проверка потомка на полиндром №3")
    void test3() {
        boolean actual = Task5.isPalindromeDescendant(11211230);
        boolean expected = true;
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Проверка потомка на полиндром №4")
    void test4() {
        boolean actual = Task5.isPalindromeDescendant(13001120);
        boolean expected = true;
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Проверка потомка на полиндром №5")
    void test5() {
        boolean actual = Task5.isPalindromeDescendant(23336014);
        boolean expected = true;
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Проверка потомка на полиндром №6")
    void test6() {
        boolean actual = Task5.isPalindromeDescendant(11);
        boolean expected = true;
        assertEquals(expected, actual);
    }
}
