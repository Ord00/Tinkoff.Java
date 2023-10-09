package edu.hw1;

import java.util.Scanner;
import org.apache.logging.log4j.LogManager;

@SuppressWarnings("uncommentedmain")

public class Task4 {
    private final static org.apache.logging.log4j.Logger LOGGER = LogManager.getLogger();

    private Task4() {
    }

    public static String fixString(String s) {
        char[] result = s.toCharArray();
        int length = s.length();
        char tmp;
        for (int i = 0; i < length - 1; i += 2) {
            tmp = result[i];
            result[i] = result[i + 1];
            result[i + 1] = tmp;
        }
        return new String(result);
    }

    public static void main(String[] args) {
        String result;
        String s;
        Scanner in = new Scanner(System.in);
        LOGGER.info("Введите строку: ");
        s = in.nextLine();
        result = fixString(s);
        LOGGER.info("Отредактированная строка: {} \n", result);
        in.close();
    }
}
