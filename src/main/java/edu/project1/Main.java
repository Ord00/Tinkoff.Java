package edu.project1;

public final class Main {

    private Main() {
    }

    public static void main(String[] args) {
        ConsoleHangman consoleHangMan = new ConsoleHangman();
        consoleHangMan.game(Dictionary.randomWord());
/*        ConsoleHangman consoleHangMan = new ConsoleHangman("r");
        consoleHangMan.game("obstacle");*/
    }
}
