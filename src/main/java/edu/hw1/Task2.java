package edu.hw1;

import java.util.Scanner;
import org.apache.logging.log4j.LogManager;

@SuppressWarnings("uncommentedmain")

public class Task2 {
    final static int K = 10;
    private final static org.apache.logging.log4j.Logger LOGGER = LogManager.getLogger();

    private Task2() {
    }

    public static int countDigits(Integer num) {
        int result = 0;
        int x = Math.abs(num);
        while (x > 0) {
            ++result;
            x /= K;
        }
        return result;
    }

    public static void main(String[] args) {
        int result;
        int num;
        Scanner in = new Scanner(System.in);
        LOGGER.info("Введите число: ");
        num = in.nextInt();
        result = countDigits(num);
        LOGGER.info("Кол-во цифр в числе: {} \n", result);
        in.close();
    }
}
