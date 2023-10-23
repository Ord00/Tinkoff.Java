package edu.hw3;

import java.util.ArrayList;
import java.util.Scanner;

@SuppressWarnings({"RegexpSinglelineJava", "uncommentedmain"})
public class Task1 {
    private Task1() {

    }

    final static int LETTERS = 26;

    public static String atbash(String source) {
        String alphabetUpper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String alphabetLower = "abcdefghijklmnopqrstuvwxyz";
        ArrayList<Character> arrayList = new ArrayList<>();
        int len = source.length();
        char symbol;
        for (int i = 0; i < len; ++i) {
            symbol = source.charAt(i);
            if (symbol >= 'a' && symbol <= 'z') {
                arrayList.add(alphabetLower.charAt(LETTERS - 1 - alphabetLower.indexOf(symbol)));
            } else if (symbol >= 'A' && symbol <= 'Z') {
                arrayList.add(alphabetUpper.charAt(LETTERS - 1 - alphabetUpper.indexOf(symbol)));
            } else {
                arrayList.add(symbol);
            }
        }
        String result = "";
        int size = arrayList.size();
        for (int i = 0; i < size; ++i) {
            result += arrayList.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        String source;
        Scanner in = new Scanner(System.in);
        System.out.print("Введите строку: ");
        source = in.nextLine();
        String result = atbash(source);
        System.out.println("Преобразованная строка: " + result);
    }
}
