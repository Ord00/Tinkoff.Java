package edu.hw1;

import java.util.Scanner;
import org.apache.logging.log4j.LogManager;

@SuppressWarnings("uncommentedmain")

public class Task1 {
    private final static org.apache.logging.log4j.Logger LOGGER = LogManager.getLogger();

    private Task1() {
    }

    public static Boolean checkString(String s) {
        boolean result = true;
        int length = s.length();
        Integer colonPos = -1;
        for (Integer i = 0; i < length & result; ++i) {
            if (colonPos.equals(-1) & s.charAt(i) == ':') {
                if (i.equals(0) | i.equals(length - 1)) {
                    result = false;
                } else {
                    colonPos = i;
                }
            } else if (s.charAt(i) < '0' | s.charAt(i) > '9') {
                result = false;
            }
        }
        if (colonPos.equals(-1)) {
            result = false;
        }
        return result;
    }

    public static int minutesToSeconds(String s) {
        final int k = 60;
        int result;
        if (!checkString(s)) {
            result = -1;
        } else {
            int colonPos = s.indexOf(':');
            String sub1 = s.substring(0, colonPos);
            String sub2 = s.substring(colonPos + 1);
            int min = Integer.parseInt(sub1);
            int sec = Integer.parseInt(sub2);
            if (sec >= k || sec < 0) {
                result = -1;
            } else {
                result = min * k + sec;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int result;
        String s;
        Scanner in = new Scanner(System.in);
        LOGGER.info("Введите строку с длиной видео: ");
        s = in.nextLine();
        result = minutesToSeconds(s);
        LOGGER.info("Длина видео: {} \n", result);
        in.close();
    }
}
