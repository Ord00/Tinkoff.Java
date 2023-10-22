package edu.project1;

import java.util.Arrays;
import java.util.Scanner;

@SuppressWarnings("RegexpSinglelineJava")
class ConsoleHangman {
    final static int TWENTYSIX = 26;
    final static int FIVE = 5;
    private static Scanner scanner;

    public ConsoleHangman() {
        scanner = new Scanner(System.in);
    }

    public ConsoleHangman(String in) {
        scanner = new Scanner(in);
    }

    public static void Game(String guessWord) {
        if (guessWord.length() > 1) {
            Session session = new Session(guessWord, FIVE);
            String symbol;
            boolean isEnd = false;
            boolean isSym;
            char[] usedsymbols = new char[TWENTYSIX];
            int pos = 0;
            int len = session.getAnswerLength();
            while (!session.attemptsOverflow() && !isEnd) {
                isSym = false;
                System.out.print("> Guess a letter:\n");
                System.out.print("< ");
                symbol = CorrectionOfSymbol.correctSymbol(scanner, usedsymbols, pos);
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
                            "> Missed, mistake " + session.getAttempts() + " out of " + session.getMaxAttempts()
                                + ".\n");
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
        } else {
            System.out.print("Загаданное слово имеет некорректную длину\n");
        }
    }

    public static void main(String[] args) {
        ConsoleHangman ConsoleHangMan = new ConsoleHangman("h\ne\nv\ne\na\nn");
        ConsoleHangMan.Game("obstacle");
    }
}
