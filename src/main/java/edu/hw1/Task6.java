package edu.hw1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import org.apache.logging.log4j.LogManager;

@SuppressWarnings("uncommentedmain")

public class Task6 {
    final static int LEN = 4;
    final static int BASIS = 10;
    final static int K = 6174;
    private final static org.apache.logging.log4j.Logger LOGGER = LogManager.getLogger();

    private Task6() {
    }

    public static Integer[] numToArray(Integer num) {
        Integer x = num;
        Integer[] result = new Integer[LEN];
        for (int i = LEN - 1; i >= 0; --i) {
            result[i] = x % BASIS;
            x /= BASIS;
        }
        return result;
    }

    public static Integer numFromArray(Integer[] num) {
        int result = 0;
        for (int i = 0; i < LEN; ++i) {
            result *= BASIS;
            result += num[i];
        }
        return result;
    }

    public static int countK(Integer num) {
        int result = 0;
        Integer dif = num;
        if (dif != K) {
            Integer[] source = numToArray(dif);
            Integer[] a = Arrays.copyOf(source, LEN);
            Arrays.sort(a);
            Integer[] b = Arrays.copyOf(source, LEN);
            Arrays.sort(b, Comparator.reverseOrder());
            Integer sub = numFromArray(a);
            Integer red = numFromArray(b);
            dif = red - sub;
            result = countK(dif);
            ++result;
        }
        return result;
    }

    public static void main(String[] args) {
        int result;
        int num;
        Scanner in = new Scanner(System.in);
        LOGGER.info("Введите число: ");
        num = in.nextInt();
        result = countK(num);
        LOGGER.info("Кол-во шагов: {} \n", result);
        in.close();
    }
}
