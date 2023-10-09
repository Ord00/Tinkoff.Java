package edu.hw1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Task5Test {

    @Test
    void isPalindromeDescendant() {
        boolean actual = Task5.isPalindromeDescendant(123456);
        boolean expected = false;
        assertEquals(expected, actual);

        actual = Task5.isPalindromeDescendant(567879790);
        assertEquals(expected, actual);

        actual = Task5.isPalindromeDescendant(11211230);
        expected = true;
        assertEquals(expected, actual);

        actual = Task5.isPalindromeDescendant(13001120);
        assertEquals(expected, actual);

        actual = Task5.isPalindromeDescendant(23336014);
        assertEquals(expected, actual);

        actual = Task5.isPalindromeDescendant(11);
        assertEquals(expected, actual);

    }
}
