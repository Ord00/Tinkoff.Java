package edu.hw1;

import java.util.Scanner;
import org.apache.logging.log4j.LogManager;

@SuppressWarnings("uncommentedmain")

public class Task7 {
    final static int ZERO = 0;
    final static int BASICS = 2;
    private final static org.apache.logging.log4j.Logger LOGGER = LogManager.getLogger();

    private Task7() {
    }

    public static int rotateLeft(int n, int shift) {
        int result;
        if (n >= ZERO) {
            if (shift >= ZERO) {
                String s = Integer.toBinaryString(n);
                char[] array = s.toCharArray();
                char tmp;
                int length = s.length();
                for (int i = ZERO; i < shift; ++i) {
                    tmp = array[ZERO];
                    for (int j = ZERO; j < length - 1; ++j) {
                        array[j] = array[j + 1];
                    }
                    array[length - 1] = tmp;
                }
                result = Integer.parseInt(new String(array), BASICS);
            } else {
                result = rotateRight(n, Math.abs(shift));
            }
        } else {
            result = -1;
        }
        return result;
    }

    public static int rotateRight(int n, int shift) {
        int result;
        if (n >= ZERO) {
            if (shift >= ZERO) {
                String s = Integer.toBinaryString(n);
                char[] array = s.toCharArray();
                char tmp;
                int length = s.length();
                for (int i = ZERO; i < shift; ++i) {
                    tmp = array[length - 1];
                    for (int j = length - 1; j > ZERO; --j) {
                        array[j] = array[j - 1];
                    }
                    array[ZERO] = tmp;
                }
                result = Integer.parseInt(new String(array), BASICS);
            } else {
                result = rotateLeft(n, Math.abs(shift));
            }
        } else {
            result = -1;
        }
        return result;
    }

    public static void main(String[] args) {
        int result;
        int num;
        int shift;
        Scanner in = new Scanner(System.in);
        LOGGER.info("Введите число: ");
        num = in.nextInt();
        LOGGER.info("Введите сдвиг: ");
        shift = in.nextInt();
        result = rotateLeft(num, shift);
        LOGGER.info("Результат сдвига влево: {} \n", result);
        result = rotateRight(num, shift);
        LOGGER.info("Результат сдвига вправо: {} \n", result);
        in.close();
    }
}

