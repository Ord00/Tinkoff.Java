package edu.project1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.*;

public class pr1Test {
    @Test
    @DisplayName("Игра не запускается, если загадываемое слово имеет некорректную длину")
    void test1() {
        String consoleOutput;
        PrintStream originalOut = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(100);
        PrintStream capture = new PrintStream(outputStream);
        System.setOut(capture);

        ConsoleHangman ConsoleHangMan = new ConsoleHangman("h");
        ConsoleHangMan.game("h");

        capture.flush();
        consoleOutput = outputStream.toString();
        assertEquals("Загаданное слово имеет некорректную длину\n", consoleOutput);
    }

    @Test
    @DisplayName("После превышения заданного количества попыток игра всегда возвращает поражение")
    void test2() {
        String consoleOutput;
        PrintStream originalOut = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(100);
        PrintStream capture = new PrintStream(outputStream);
        System.setOut(capture);

        ConsoleHangman ConsoleHangMan = new ConsoleHangman("h\ne\nv\ne\na\nn\nk\nx\nb");
        ConsoleHangMan.game("obstacle");

        capture.flush();
        consoleOutput = outputStream.toString();
        assertEquals("You lost!", consoleOutput.substring(consoleOutput.length() - 10, consoleOutput.length() - 1));
    }

    @Test
    @DisplayName("Проверка, что состояние игры корректно изменяется при не угадывании")
    void test3() {
        String consoleOutput;
        PrintStream originalOut = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(100);
        PrintStream capture = new PrintStream(outputStream);
        System.setOut(capture);

        ConsoleHangman ConsoleHangMan = new ConsoleHangman("r\ne\nc\nt\na\nn\ng\nl\ne\nx\nm");
        ConsoleHangMan.game("obstacle");

        capture.flush();
        consoleOutput = outputStream.toString();
        String s = "Missed, mistake 1 out of 5.";
        int index = consoleOutput.indexOf("Missed, mistake 1 out of 5.");
        assertEquals("Missed, mistake 1 out of 5.", consoleOutput.substring(index, index + s.length()));
    }

    @Test
    @DisplayName("Проверка, что состояние игры корректно изменяется при угадывании")
    void test4() {
        String consoleOutput;
        PrintStream originalOut = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(100);
        PrintStream capture = new PrintStream(outputStream);
        System.setOut(capture);

        ConsoleHangman ConsoleHangMan = new ConsoleHangman("r\ne\nc\nt\na\nn\ng\nl\ne\nx\nm");
        ConsoleHangMan.game("obstacle");

        capture.flush();
        consoleOutput = outputStream.toString();
        String s = "Hit!";
        int index = consoleOutput.indexOf("Hit!");
        assertEquals("Hit!", consoleOutput.substring(index, index + s.length()));
    }

    @Test
    @DisplayName("Проверка, что при отгадывании ввод строки длиной больше чем 1 (опечатка) " +
        "приводит к повторному вводу, без изменения состояния")
    void test5() {
        String consoleOutput;
        PrintStream originalOut = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(100);
        PrintStream capture = new PrintStream(outputStream);
        System.setOut(capture);

        ConsoleHangman ConsoleHangMan = new ConsoleHangman("r\ne\ncngk\nt\na\nn\ng\nl\ne\nx\nm");
        ConsoleHangMan.game("obstacle");

        capture.flush();
        consoleOutput = outputStream.toString();
        String s = "> Write correct letter!";
        int index = consoleOutput.indexOf("> Write correct letter!");
        assertEquals("> Write correct letter!", consoleOutput.substring(index, index + s.length()));
    }
}
