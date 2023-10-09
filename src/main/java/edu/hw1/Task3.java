package edu.hw1;

import java.util.Arrays;
import java.util.Scanner;
import org.apache.logging.log4j.LogManager;

@SuppressWarnings("uncommentedmain")

public class Task3 {
    private final static org.apache.logging.log4j.Logger LOGGER = LogManager.getLogger();

    private Task3() {
    }

    public static boolean isNestable(int[] a1, int[] a2) {
        boolean result = false;
        if (a1.length != 0 && a2.length != 0) {

            int min1 = Arrays.stream(a1).min().getAsInt();
            int min2 = Arrays.stream(a2).min().getAsInt();
            int max1 = Arrays.stream(a1).max().getAsInt();
            int max2 = Arrays.stream(a2).max().getAsInt();
            if (min1 > min2 & max1 < max2) {
                result = true;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        boolean result;
        Scanner in = new Scanner(System.in);
        LOGGER.info("Введите размер 1-го массива: ");
        int size1 = in.nextInt();
        int[] a1 = new int[size1];
        if (size1 != 0) {
            LOGGER.info("Введите элементы 1-го массива: ");
            for (int i = 0; i < size1; ++i) {
                a1[i] = in.nextInt();
            }
        }
        LOGGER.info("Введите размер 2-го массива: ");
        int size2 = in.nextInt();
        int[] a2 = new int[size2];
        if (size2 != 0) {
            LOGGER.info("Введите элементы 2-го массива: ");
            for (int i = 0; i < size2; ++i) {
                a2[i] = in.nextInt();
            }
        }
        result = isNestable(a1, a2);
        LOGGER.info("Ответ: {} \n", result);
        in.close();
    }
}
