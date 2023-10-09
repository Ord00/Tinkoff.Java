package edu.hw1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task2Test {

    @Test
    void countDigits() {
        int actual = Task2.countDigits(1234);
        int expected = 4;
        assertEquals(expected, actual);

        actual = Task2.countDigits(0);
        expected = 0;
        assertEquals(expected, actual);

        actual = Task2.countDigits(-12134);
        expected = 5;
        assertEquals(expected, actual);

        actual = Task2.countDigits(1211);
        expected = 4;
        assertEquals(expected, actual);
    }
}
