package edu.hw1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task1Test {
    @Test
    void minutesToSeconds() {
        int actual = Task1.minutesToSeconds(":11");
        int expected = -1;
        assertEquals(expected, actual);

        actual = Task1.minutesToSeconds("12341:");
        assertEquals(expected, actual);

        actual = Task1.minutesToSeconds("-88:11");
        assertEquals(expected, actual);

        actual = Task1.minutesToSeconds("1289");
        assertEquals(expected, actual);

        actual = Task1.minutesToSeconds("ab:cd");
        assertEquals(expected, actual);

        actual = Task1.minutesToSeconds(":9:");
        assertEquals(expected, actual);

        actual = Task1.minutesToSeconds("");
        assertEquals(expected, actual);

        actual = Task1.minutesToSeconds("12:11");
        expected = 731;
        assertEquals(expected, actual);
    }
}
