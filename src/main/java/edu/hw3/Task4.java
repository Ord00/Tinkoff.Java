package edu.hw3;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

@SuppressWarnings({"RegexpSinglelineJava", "uncommentedmain", "magicnumber"})
public class Task4 {
    private Task4() {

    }

    final static Integer MAX = 4000;

    public static String convertToRoman(Integer num) {
        String result = "\"";
        HashMap<String, Integer> hashMap = new LinkedHashMap<>() {{
            put("M", 1000);
            put("CM", 900);
            put("D", 500);
            put("CD", 400);
            put("C", 100);
            put("XC", 90);
            put("L", 50);
            put("XL", 40);
            put("X", 10);
            put("IX", 9);
            put("V", 5);
            put("IV", 4);
            put("I", 1);
        }};
        String key;
        Integer value;
        Integer x = num;
        while (x > 0 && x < MAX) {
            for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
                key = entry.getKey();
                value = entry.getValue();
                while (x >= value) {
                    result += key;
                    x -= value;
                }
            }
        }
        result += "\"";
        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите арабское число: ");
        Integer num = in.nextInt();
        System.out.println("Римская интерпретация числа: " + convertToRoman(num));
    }
}
