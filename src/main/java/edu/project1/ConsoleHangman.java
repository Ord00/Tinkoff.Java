package edu.project1;

import java.util.Arrays;
import java.util.Scanner;

@SuppressWarnings({"RegexpSinglelineJava", "uncommentedmain", "HideUtilityClassConstructor"})
public class ConsoleHangman {
    final static int TWENTYSIX = 26;
    final static int FIVE = 5;
    final static String WORD = "> The word: ";
    final static String N = ">\n";
    private static Scanner scanner;

    private ConsoleHangman() {
        scanner = new Scanner(System.in);
    }

    ConsoleHangman(String in) {
        scanner = new Scanner(in);
    }

    public static void game(String guessWord) {
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
                if (symbol.equals("giveup")) {
                    break;
                }
                ++pos;
                for (int i = 0; i < len; ++i) {
                    if (symbol.charAt(0) == session.getAnswer().charAt(i)) {
                        session.setUserAnswer(symbol.charAt(0), i);
                        isSym = true;
                    }
                }
                if (isSym) {
                    System.out.print("\n> Hit!\n");
                    System.out.print(N);
                    System.out.print(WORD + Arrays.toString(session.getUserAnswer()) + '\n');
                    System.out.print(N);
                    if (Arrays.equals(session.getAnswer().toCharArray(), session.getUserAnswer())) {
                        System.out.print("> You won!\n");
                        isEnd = true;
                    }
                } else {
                    session.addAttempt();
                    System.out.print(
                        "\n> Missed, mistake " + session.getAttempts() + " out of " + session.getMaxAttempts()
                            + ".\n");
                    System.out.print(N);
                    System.out.print(WORD + Arrays.toString(session.getUserAnswer()) + '\n');
                    System.out.print(N);
                    if (session.getAttempts() == session.getMaxAttempts()) {
                        System.out.print(N);
                        System.out.print("> You lost!\n");
                        isEnd = true;
                    }
                }
            }
        } else {
            System.out.print("Загаданное слово имеет некорректную длину\n");
        }
    }

    public static void main(String[] args) {
        ConsoleHangman consoleHangMan = new ConsoleHangman();
        consoleHangMan.game("obstacle");
/*        ConsoleHangman consoleHangMan = new ConsoleHangman("h\ne\nv\ne\na\nn\nk\nx\nb");
        consoleHangMan.game("obstacle");*/
    }
}
