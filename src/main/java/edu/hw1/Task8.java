package edu.hw1;

import java.util.Scanner;
import org.apache.logging.log4j.LogManager;

@SuppressWarnings("uncommentedmain")

public class Task8 {
    final static int ONE = 1;
    final static int TWO = 2;
    final static int EIGHT = 8;
    final static int ZERO = 0;
    private final static org.apache.logging.log4j.Logger LOGGER = LogManager.getLogger();

    private Task8() {
    }

    public static boolean left(int[][] a, int i, int j) {
        boolean result = false;
        if (i - TWO >= ZERO) {
            if (j + ONE < EIGHT && a[i - TWO][j + ONE] == ONE
                || j - ONE >= ZERO && a[i - TWO][j - ONE] == ONE) {
                result = true;
            }
        }
        return result;
    }

    public static boolean right(int[][] a, int i, int j) {
        boolean result = false;
        if (i + TWO < EIGHT) {
            if (j + ONE < EIGHT && a[i + TWO][j + ONE] == ONE
                || j - ONE >= ZERO && a[i + TWO][j - ONE] == ONE) {
                result = true;
            }
        }
        return result;
    }

    public static boolean up(int[][] a, int i, int j) {
        boolean result = false;
        if (j + TWO < EIGHT) {
            if (i - ONE >= ZERO && a[i - ONE][j + TWO] == ONE
                || i + ONE < EIGHT && a[i + ONE][j + TWO] == ONE) {
                result = true;
            }
        }
        return result;
    }

    public static boolean down(int[][] a, int i, int j) {
        boolean result = false;
        if (j - TWO >= ZERO) {
            if (i - ONE >= ZERO && a[i - ONE][j - TWO] == ONE
                || i + ONE < EIGHT && a[i + ONE][j - TWO] == ONE) {
                result = true;
            }
        }
        return result;
    }

    public static boolean knightBoardCapture(int[][] a) {
        boolean result = true;
        for (int i = ZERO; i < EIGHT; ++i) {
            for (int j = ZERO; j < EIGHT; ++j) {
                if (a[i][j] == ONE) {
                    if (left(a, i, j) || up(a, i, j) || right(a, i, j) || down(a, i, j)) {
                        result = false;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        boolean result;
        int[][] a = new int[EIGHT][EIGHT];
        Scanner in = new Scanner(System.in);
        LOGGER.info("Введите элементы матрицы: ");
        for (int i = ZERO; i < EIGHT; ++i) {
            for (int j = ZERO; j < EIGHT; ++j) {
                a[i][j] = in.nextInt();
            }
        }
        result = knightBoardCapture(a);
        LOGGER.info("Ни один конь не может захватить другого коня: {} \n", result);
        in.close();
    }
}
