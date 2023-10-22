package edu.project1;

import java.util.Arrays;
import java.util.Scanner;

class ConsoleHangman {
    private static Scanner scanner;

    public ConsoleHangman() {
        scanner = new Scanner(System.in);
    }

    public ConsoleHangman(String in) {
        scanner = new Scanner(in);
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
            System.out.print("\n> Write correct letter!\n");
            System.out.print("\n> Guess a letter:\n");
            System.out.print("< ");
            symbol = in.nextLine();
        }
        return symbol;
    }

    public static void Game(String guessWord) {
        if (guessWord.length() > 1) {
            Session session = new Session(guessWord, 5);
            String symbol;
            boolean isEnd = false;
            boolean isSym;
            char[] usedsymbols = new char[26];
            int pos = 0;
            int len = session.getAnswerLength();
            while (!session.attemptsOverflow() && !isEnd) {
                isSym = false;
                System.out.print("> Guess a letter:\n");
                System.out.print("< ");
                symbol = correctSymbol(scanner, usedsymbols, pos);
                System.out.print("\n");
                if (!symbol.equals("giveup")) {
                    ++pos;
                    for (int i = 0; i < len; ++i) {
                        if (symbol.charAt(0) == session.getAnswer().charAt(i)) {
                            session.setUserAnswer(symbol.charAt(0), i);
                            isSym = true;
                        }
                    }
                    if (isSym) {
                        System.out.print("> Hit!\n");
                        System.out.print(">\n");
                        System.out.print("> The word: " + Arrays.toString(session.getUserAnswer()) + '\n');
                        System.out.print(">\n");
                        if (Arrays.equals(session.getAnswer().toCharArray(), session.getUserAnswer())) {
                            System.out.print("> You won!\n");
                            isEnd = true;
                        }
                    } else {
                        session.addAttempt();
                        System.out.print(
                            "> Missed, mistake " + session.getAttempts() + " out of " + session.getMaxAttempts() + ".\n");
                        System.out.print(">\n");
                        System.out.print("> The word: " + Arrays.toString(session.getUserAnswer()) + '\n');
                        System.out.print(">\n");
                        if (session.getAttempts() == session.getMaxAttempts()) {
                            System.out.print(">\n");
                            System.out.print("> You lost!\n");
                            isEnd = true;
                        }
                    }
                } else {
                    isEnd = true;
                }
            }
        }
        else {
            System.out.print("Загаданное слово имеет некорректную длину\n");
        }
    }

    public static void main(String[] args) {
        ConsoleHangman ConsoleHangMan = new ConsoleHangman("h\ne\nv\ne\na\nn");
        ConsoleHangMan.Game("obstacle");
    }
}
