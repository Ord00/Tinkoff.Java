package edu.project1;

import java.util.Arrays;
import java.util.Random;
import org.jetbrains.annotations.NotNull;

class Session implements Dictionary {
    private final String answer;
    private final char[] userAnswer;
    private final int maxAttempts;
    private int attempts;

    final static int THREE = 3;

    Session(String answer, int maxAttempts) {
        this.answer = answer;
        this.userAnswer = new char[answer.length()];
        Arrays.fill(userAnswer, '*');
        this.maxAttempts = maxAttempts;
        this.attempts = 0;
    }

    @NotNull public String randomWord() {
        Random random = new Random();
        String result = switch (random.nextInt(THREE)) {
            case 0 -> "hello";
            case 1 -> "obstacle";
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
