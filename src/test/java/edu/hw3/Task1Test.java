package edu.hw3;

import edu.hw1.Task7;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Task1Test {

    @Test
    @DisplayName("Проверка примера №1")
    void test1() {
        String actual = Task1.atbash("Hello world!");
        String expected = "Svool dliow!";
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Проверка примера №2")
    void test2() {
        String actual = Task1.atbash("Any fool can write code that a computer can understand. "
            + "Good programmers write code that humans can understand. ― Martin Fowler");
        String expected = "Zmb ullo xzm dirgv xlwv gszg z xlnkfgvi xzm fmwvihgzmw. Tllw kiltiznnvih "
            + "dirgv xlwv gszg sfnzmh xzm fmwvihgzmw. ― Nzigrm Uldovi";
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Проверка строки из символов, не являющихся буквами латинского алфавита")
    void test3() {
        String actual = Task1.atbash("!!!");
        String expected = "!!!";
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Проверка пустой строки")
    void test4() {
        String actual = Task1.atbash("");
        String expected = "";
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Проверка строки из букв русского алфавита")
    void test5() {
        String actual = Task1.atbash("абвгд");
        String expected = "абвгд";
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Проверка строки из букв латинского алфавита как верхнего, так и нижнего регистров")
    void test6() {
        String actual = Task1.atbash("AxyzCDmn");
        String expected = "ZcbaXWnm";
        assertEquals(expected, actual);
    }
}
