package edu.hw3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task2Test {
    @Test
    @DisplayName("Проверка примера №1")
    void test1() {
        String actual = Task2.clusterize("()()()");
        String expected = "[\"()\", \"()\", \"()\"]";
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Проверка примера №2")
    void test2() {
        String actual = Task2.clusterize("((()))");
        String expected = "[\"((()))\"]";
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Проверка примера №3")
    void test3() {
        String actual = Task2.clusterize("((()))(())()()(()())");
        String expected = "[\"((()))\", \"(())\", \"()\", \"()\", \"(()())\"]";
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Проверка примера №4")
    void test4() {
        String actual = Task2.clusterize("((())())(()(()()))");
        String expected = "[\"((())())\", \"(()(()()))\"]";
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Проверка неверной строки №1")
    void test5() {
        String actual = Task2.clusterize("))((");
        String expected = "[]";
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Проверка неверной строки №2")
    void test6() {
        String actual = Task2.clusterize("((((");
        String expected = "[]";
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Проверка неверной строки №3")
    void test7() {
        String actual = Task2.clusterize("(()))");
        String expected = "[]";
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Проверка неверной строки №4")
    void test8() {
        String actual = Task2.clusterize("abcd");
        String expected = "[]";
        assertEquals(expected, actual);
    }
}
