package edu.hw3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task4Test {
    @Test
    @DisplayName("Проверка примера №1")
    void test1() {
        String actual = Task4.convertToRoman(2);
        String expected = "\"II\"";
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Проверка примера №2")
    void test2() {
        String actual = Task4.convertToRoman(12);
        String expected = "\"XII\"";
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Проверка примера №3")
    void test3() {
        String actual = Task4.convertToRoman(16);
        String expected = "\"XVI\"";
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Проверка нуля")
    void test4() {
        String actual = Task4.convertToRoman(0);
        String expected = "\"\"";
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Проверка числа 555")
    void test5() {
        String actual = Task4.convertToRoman(555);
        String expected = "\"DLV\"";
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Проверка числа 5439")
    void test6() {
        String actual = Task4.convertToRoman(5439);
        String expected = "\"MMMMMCDXXXIX\"";
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Проверка числа 80")
    void test7() {
        String actual = Task4.convertToRoman(80);
        String expected = "\"LXXX\"";
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Проверка числа 1000")
    void test8() {
        String actual = Task4.convertToRoman(1000);
        String expected = "\"M\"";
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Проверка числа 214")
    void test9() {
        String actual = Task4.convertToRoman(214);
        String expected = "\"CCXIV\"";
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Проверка отрицательного числа -101")
    void test10() {
        String actual = Task4.convertToRoman(-101);
        String expected = "\"\"";
        assertEquals(expected, actual);
    }
}
