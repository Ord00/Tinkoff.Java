package edu.project1;

import java.util.Random;
import java.util.Arrays;
import org.jetbrains.annotations.NotNull;

@SuppressWarnings("MagicNumber")
interface Dictionary {
    @NotNull String randomWord();
}

class Session implements Dictionary {
    private final String answer;
    private final char[] userAnswer;
    private final int maxAttempts;
    private int attempts;

    final static int SIX = 6;

    Session(String answer, int maxAttempts) {
        this.answer = answer;
        this.userAnswer = new char[answer.length()];
        Arrays.fill(userAnswer, '*');
        this.maxAttempts = maxAttempts;
        this.attempts = 0;
    }

    @NotNull public String randomWord() {
        Random random = new Random();
        String result = switch (random.nextInt(SIX)) {
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
}
