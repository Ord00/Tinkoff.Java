package edu.hw1;

import java.util.Scanner;
import org.apache.logging.log4j.LogManager;

@SuppressWarnings("uncommentedmain")

public class Task5 {
    private final static org.apache.logging.log4j.Logger LOGGER = LogManager.getLogger();

    private Task5() {
    }

    public static boolean isPalindromeDescendant(int num) {
        boolean result = false;
        boolean check;
        String s = Integer.toString(num);
        int size = s.length();
        while (!result && size > 1) {
            check = true;
            for (int i = 0; i < size / 2 && check; ++i) {
                if (s.charAt(i) != s.charAt(size - i - 1)) {
                    check = false;
                }
                if (check) {
                    result = true;
                } else {
                    char[] a = s.toCharArray();
                    s = "";
                    for (int j = 0; j < size - 1; j += 2) {
                        s += (a[j] - '0' + a[j + 1] - '0');
                    }
                    size = s.length();
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        boolean result;
        int num;
        Scanner in = new Scanner(System.in);
        LOGGER.info("Введите число: ");
        num = in.nextInt();
        result = isPalindromeDescendant(num);
        LOGGER.info("Результат проверки на полиндром: {} \n", result);
        in.close();
    }
}
