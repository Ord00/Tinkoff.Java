package edu.hw3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task5Test {
    @Test
    @DisplayName("Проверка примера №1")
    void test1() {
        ArrayList<String> list =
            new ArrayList<>(Arrays.asList("John Locke", "Thomas Aquinas", "David Hume", "Rene Descartes"));
        String actual = Task5.parseContacts(list, "ASC").toString();
        String expected = "[Thomas Aquinas, Rene Descartes, David Hume, John Locke]";
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Проверка примера №2")
    void test2() {
        ArrayList<String> list =
            new ArrayList<>(Arrays.asList("Paul Erdos", "Leonhard Euler", "Carl Gauss"));
        String actual = Task5.parseContacts(list, "DESC").toString();
        String expected = "[Carl Gauss, Leonhard Euler, Paul Erdos]";
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Проверка примера №3")
    void test3() {
        ArrayList<String> list = new ArrayList<>();
        String actual = Task5.parseContacts(list, "DESC").toString();
        String expected = "[]";
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Проверка примера №4")
    void test4() {
        String actual = Task5.parseContacts(null, "DESC").toString();
        String expected = "[]";
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Проверка массива с данными, содержащими только имя №1")
    void test5() {
        ArrayList<String> list =
            new ArrayList<>(Arrays.asList("Hamilton", "Thomas", "Vettel", "Tom Power", "Will Henderson", "Chris"));
        String actual = Task5.parseContacts(list, "ASC").toString();
        String expected = "[Chris, Hamilton, Will Henderson, Tom Power, Thomas, Vettel]";
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Проверка массива с данными, содержащими только имя №2")
    void test6() {
        ArrayList<String> list =
            new ArrayList<>(Arrays.asList("Hamilton", "Thomas", "Vettel", "Tom Power", "Will Henderson", "Chris"));
        String actual = Task5.parseContacts(list, "DESC").toString();
        String expected = "[Vettel, Thomas, Tom Power, Will Henderson, Hamilton, Chris]";
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Проверка с вводом неверного типа сортировки №1")
    void test7() {
        ArrayList<String> list =
            new ArrayList<>(Arrays.asList("Paul Erdos", "Leonhard Euler", "Carl Gauss"));
        String actual = Task5.parseContacts(list, "D!SC").toString();
        String expected = "[]";
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Проверка с вводом неверного типа сортировки №2")
    void test8() {
        ArrayList<String> list =
            new ArrayList<>(Arrays.asList("Paul Erdos", "Leonhard Euler", "Carl Gauss"));
        String actual = Task5.parseContacts(list, "A S C").toString();
        String expected = "[]";
        assertEquals(expected, actual);
    }
}
