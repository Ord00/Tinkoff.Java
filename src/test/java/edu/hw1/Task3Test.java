package edu.hw1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Task3Test {

    @Test
    void isNestable() {
        int[] a1 = new int[] {1, 2, 3, 4};
        int[] a2 = new int[] {2, 3, 4};
        boolean actual = Task3.isNestable(a1, a2);
        boolean expected = false;
        assertEquals(expected, actual);

        a1 = new int[] {3, 1};
        a2 = new int[] {4, 0};
        actual = Task3.isNestable(a1, a2);
        expected = true;
        assertEquals(expected, actual);

        a1 = new int[] {};
        a2 = new int[] {1, 7, 9};
        actual = Task3.isNestable(a1, a2);
        expected = false;
        assertEquals(expected, actual);
    }
}
