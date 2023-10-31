package edu.project1;

import java.util.Arrays;

class Session {
    private final String answer;
    private final char[] userAnswer;
    private final int maxAttempts;
    private int attempts;

    Session(String answer, int maxAttempts) {
        this.answer = answer;
        this.userAnswer = new char[answer.length()];
        Arrays.fill(userAnswer, '*');
        this.maxAttempts = maxAttempts;
        this.attempts = 0;
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
