package edu.hw3;

import java.util.ArrayDeque;
import java.util.Scanner;

@SuppressWarnings({"RegexpSinglelineJava", "uncommentedmain"})
public class Task2 {
    private Task2() {

    }

    public static boolean checkSource(String source) {
        boolean result = true;
        int cntLeftBr = 0;
        int cntRightBr = 0;
        int len = source.length();
        for (int i = 0; i < len; ++i) {
            if (source.charAt(i) == '(') {
                ++cntLeftBr;
            } else if (source.charAt(i) == ')') {
                ++cntRightBr;
            }
            if (cntLeftBr - cntRightBr < 0) {
                result = false;
                break;
            }
        }
        return result;
    }

    public static String clusterize(String source) {
        String result = "[";
        if (checkSource(source)) {
            String cluster;
            int len = source.length();
            int i = 0;
            int cntLeftBr = 0;
            int cntRightBr = 0;
            ArrayDeque<Character> deque = new ArrayDeque<>();
            while (i < len) {
                cluster = "\"";
                deque.addLast(source.charAt(i));
                if (source.charAt(i) == '(') {
                    ++cntLeftBr;
                } else if (source.charAt(i) == ')') {
                    ++cntRightBr;
                    if (cntRightBr == cntLeftBr) {
                        while (!deque.isEmpty()) {
                            cluster += deque.pollFirst();
                        }
                        cluster += "\"";
                        if (i != len - 1) {
                            cluster += ", ";
                        }
                        cntLeftBr = 0;
                        cntRightBr = 0;
                        result += cluster;
                    }
                }
                ++i;
            }
        }
        result += "]";
        return result;
    }

    public static void main(String[] args) {
        String source;
        Scanner in = new Scanner(System.in);
        System.out.print("Введите строку: ");
        source = in.nextLine();
        String result = clusterize(source);
        System.out.println("Сгруппированная строка: " + result);
    }
}
