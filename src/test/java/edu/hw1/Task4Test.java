package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Task4Test {

    @Test
    @DisplayName("Проверка строки из цифр")
    void test1() {
        String actual = Task4.fixString("123456");
        String expected = "214365";
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Проверка строки с пробелами")
    void test2() {
        String actual = Task4.fixString("hTsii  s aimex dpus rtni.g");
        String expected = "This is a mixed up string.";
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Проверка строки из букв")
    void test3() {
        String actual = Task4.fixString("badce");
        String expected = "abcde";
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Проверка пустой строки")
    void test4() {
        String actual = Task4.fixString("");
        String expected = "";
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Проверка строки из 1-й буквы и 1-го пробела")
    void test5() {
        String actual = Task4.fixString(" j ");
        String expected = "j  ";
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Проверка строки из символов, ограниченных пробелами на концах")
    void test6() {
        String actual = Task4.fixString(" -|- ");
        String expected = "- -| ";
        assertEquals(expected, actual);
    }
}
