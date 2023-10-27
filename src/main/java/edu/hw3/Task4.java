package edu.hw3;

import java.util.Scanner;

@SuppressWarnings({"RegexpSinglelineJava", "uncommentedmain", "magicnumber"})
public class Task4 {
    private Task4() {

    }

    private final static int FOUR = 4;
    private final static Integer DECADE = 10;
    private final static Integer HALFHUNDRED = 50;
    private final static Integer HUNDRED = 100;
    private final static Integer HALFTHOUSAND = 500;
    private final static Integer THOUSAND = 1000;

    private static String letterM(Integer num) {
        String m = "M";
        return m.repeat(num);
    }

    private static String letterC(Integer num) {
        if (num.equals(FOUR)) {
            return "CD";
        } else if (!num.equals(0) && num < FOUR) {
            String m = "C";
            return m.repeat(num);
        } else {
            return "";
        }
    }

    private static String letterX(Integer num) {
        if (num.equals(FOUR)) {
            return "XL";
        } else if (!num.equals(0) && num < FOUR) {
            String x = "X";
            return x.repeat(num);
        } else {
            return "";
        }
    }

    private static String letterD(Integer num) {

        if (num.equals(0)) {
            return "";
        } else if (num.equals(FOUR)) {
            return "CM";
        }
        return "D";
    }

    private static String letterL(Integer num) {
        if (num.equals(0)) {
            return "";
        } else if (num.equals(FOUR)) {
            return "XC";
        }
        return "L";
    }

    private static String digits(Integer num) {
        return switch (num) {
            case 1 -> "I";
            case 2 -> "II";
            case 3 -> "III";
            case 4 -> "IV";
            case 5 -> "V";
            case 6 -> "VI";
            case 7 -> "VII";
            case 8 -> "VIII";
            case 9 -> "IX";
            default -> "";
        };
    }

    public static String convertToRoman(Integer num) {
        StringBuilder result = new StringBuilder("\"");
        if (num > 0 && num < FOUR * THOUSAND) {
            Integer thousands1 = num / THOUSAND;
            result.append(letterM(thousands1));
            Integer thousands2 = num % THOUSAND;

            Integer halfThousand1 = thousands2 / HALFTHOUSAND;
            result.append(letterD(halfThousand1));
            Integer halfThousand2 = thousands2 % HALFTHOUSAND;

            Integer hundreds1 = halfThousand2 / HUNDRED;
            result.append(letterC(hundreds1));
            Integer hundreds2 = halfThousand2 % HUNDRED;

            Integer halfHundred1 = hundreds2 / HALFHUNDRED;
            result.append(letterL(halfHundred1));
            Integer halfHundred2 = hundreds2 % HALFHUNDRED;

            Integer decades1 = halfHundred2 / DECADE;
            result.append(letterX(decades1));
            Integer decades2 = halfHundred2 % DECADE;

            result.append(digits(decades2));
        }
        result.append("\"");
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите арабское число: ");
        Integer num = in.nextInt();
        System.out.println("Римская интерпретация числа: " + convertToRoman(num));
    }
}
