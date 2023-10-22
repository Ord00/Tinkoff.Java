package edu.project1;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;

interface Dictionary {
    @NotNull String randomWord();
}

class Session implements Dictionary {
    private final String answer;
    private final char[] userAnswer;
    private final int maxAttempts;
    private int attempts;

    public Session(int maxAttempts) {
        this.answer = randomWord();
        this.userAnswer = new char[answer.length()];
        Arrays.fill(userAnswer, '*');
        this.maxAttempts = maxAttempts;
        this.attempts = 0;
    }

    @NotNull public String randomWord() {
        Random random = new Random();
        String result = switch (random.nextInt(6)) {
            case 0 -> "hello";
            case 1 -> "obstacle";
            case 2 -> "decision";
            case 3 -> "elephant";
            case 4 -> "majesty";
            default -> "predicament";
        };
        return result;
    }

    boolean attemptsOverflow() {
        return attempts >= maxAttempts;
    }

    void addAttempt() {
        ++attempts;
    }

    int getAttempts() {
        return attempts;
    }

    int getMaxAttempts() {
        return maxAttempts;
    }

    char[] getUserAnswer() {
        return userAnswer;
    }

    String getAnswer() {
        return answer;
    }

    int getAnswerLength() {
        return answer.length();
    }

    void setUserAnswer(char symbol, int i) {
        userAnswer[i] = symbol;
    }

/*    @NotNull GuessResult guess(char guess);

    @NotNull GuessResult giveUp();*/

}

/*sealed interface GuessResult {
    char[] state();

    int attempt();

    int maxAttempts();

    @NotNull String message();

    record Defeat(char[] state, int attempt, int maxAttempts) implements GuessResult {
    }

    record Win(...) implements GuessResult {

    }

    record SuccessfulGuess(...) implements GuessResult {
    }

    record FailedGuess(...) implements GuessResult {
    }
}*/

class ConsoleHangman {
    private final static Logger LOGGER = LogManager.getLogger();

    public static boolean checkSymbol(String symbol) {
        return symbol.length() == 1 && symbol.charAt(0) >= 'a' && symbol.charAt(0) <= 'z';
    }

    public static char correctSymbol(Scanner in) {
        String symbol = in.nextLine();
        while (!checkSymbol(symbol)) {
            LOGGER.info("> Guess a letter:");
            LOGGER.info("< ");
            symbol = in.nextLine();
        }
        return symbol.charAt(0);
    }

    public static void Game() {
        Scanner in = new Scanner(System.in);
        boolean isEnd = false;
        boolean isSym;
        Session session = new Session(5);
        char symbol;
        int len = session.getAnswerLength();
        while (!session.attemptsOverflow() && !isEnd) {
            isSym = false;
            LOGGER.info("> Guess a letter:");
            LOGGER.info("< ");
            symbol = correctSymbol(in);
            for (int i = 0; i < len; ++i) {
                if (symbol == session.getAnswer().charAt(i)) {
                    session.setUserAnswer(symbol, i);
                    isSym = true;
                }
            }
            if (isSym) {
                LOGGER.info("> Hit!");
                LOGGER.info(">");
                LOGGER.info("The word: " + Arrays.toString(session.getUserAnswer()));
                if (Arrays.equals(session.getAnswer().toCharArray(), session.getUserAnswer())) {
                    LOGGER.info(">");
                    LOGGER.info("> You won!");
                    isEnd = true;
                }
            } else {
                session.addAttempt();
                LOGGER.info("> Missed, mistake " + session.getAttempts() + " out of " + session.getMaxAttempts() + ".");
                if (session.getAttempts() == session.getMaxAttempts()) {
                    LOGGER.info(">");
                    LOGGER.info("> You lost!");
                    isEnd = true;
                }
            }
        }
        in.close();
    }

    /*    private GuessResult tryGuess(Session session, String input) {
        }

        private void printState(GuessResult guess) {
        }*/
    public static void main(String[] args) {
        Game();
    }
}
