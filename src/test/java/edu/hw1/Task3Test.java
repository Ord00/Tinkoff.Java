package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Task3Test {

    @Test
    @DisplayName("Проверка массивов с разным кол-вом элементов")
    void test1() {
        int[] a1 = new int[] {1, 2, 3, 4};
        int[] a2 = new int[] {2, 3, 4};
        boolean actual = Task3.isNestable(a1, a2);
        boolean expected = false;
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Проверка массивов с одинаковым кол-вом элементов")
    void test2() {
        int[] a1 = new int[] {3, 1};
        int[] a2 = new int[] {4, 0};
        boolean actual = Task3.isNestable(a1, a2);
        boolean expected = true;
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Проверка заполненного и пустого массивов")
    void test3() {
        int[] a1 = new int[] {};
        int[] a2 = new int[] {1, 7, 9};
        boolean actual = Task3.isNestable(a1, a2);
        boolean expected = false;
        assertEquals(expected, actual);

    }

    @Test
    @DisplayName("Проверка пустых массивов")
    void test4() {
        int[] a1 = new int[] {};
        int[] a2 = new int[] {};
        boolean actual = Task3.isNestable(a1, a2);
        boolean expected = false;
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Проверка массивов из примера №1")
    void test5() {
        int[] a1 = new int[] {1, 2, 3, 4};
        int[] a2 = new int[] {0, 6};
        boolean actual = Task3.isNestable(a1, a2);
        boolean expected = true;
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Проверка массивов из примера №2")
    void test6() {
        int[] a1 = new int[] {3, 1};
        int[] a2 = new int[] {4, 0};
        boolean actual = Task3.isNestable(a1, a2);
        boolean expected = true;
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Проверка массивов из примера №3")
    void test7() {
        int[] a1 = new int[] {9, 9, 8};
        int[] a2 = new int[] {8, 9};
        boolean actual = Task3.isNestable(a1, a2);
        boolean expected = false;
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Проверка массивов из примера №4")
    void test8() {
        int[] a1 = new int[] {1, 2, 3, 4};
        int[] a2 = new int[] {2, 3};
        boolean actual = Task3.isNestable(a1, a2);
        boolean expected = false;
        assertEquals(expected, actual);
    }
}
