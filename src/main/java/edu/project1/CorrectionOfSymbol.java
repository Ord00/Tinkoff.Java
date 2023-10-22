package edu.project1;

import java.util.Scanner;

@SuppressWarnings("RegexpSinglelineJava")
public class CorrectionOfSymbol {
    private CorrectionOfSymbol() {

    }

    public static boolean isUsedSymbol(char symbol, char[] usedsymbols, int pos) {
        boolean result = false;
        for (int i = 0; i < pos; ++i) {
            if (symbol == usedsymbols[i]) {
                result = true;
                break;
            }
        }
        if (!result) {
            usedsymbols[pos] = symbol;
        }
        return result;
    }

    public static boolean checkSymbol(String symbol, char[] usedsymbols, int pos) {
        return symbol.equals("giveup") || symbol.length() == 1 && symbol.charAt(0) >= 'a'
            && symbol.charAt(0) <= 'z' && !isUsedSymbol(symbol.charAt(0), usedsymbols, pos);
    }

    public static String correctSymbol(Scanner in, char[] usedsymbols, int pos) {
        String symbol = in.nextLine();
        while (!checkSymbol(symbol, usedsymbols, pos)) {
            System.out.print("\n> Write correct letter!");
            System.out.print("\n> Guess a letter:\n");
            System.out.print("< ");
            symbol = in.nextLine();
        }
        return symbol;
    }
}
