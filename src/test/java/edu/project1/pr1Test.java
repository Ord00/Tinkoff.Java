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
    @DisplayName("Проверка, что состояние игры корректно изменяется при неугадывании №1")
    void test3() {
        String consoleOutput;
        PrintStream originalOut = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(100);
        PrintStream capture = new PrintStream(outputStream);
        System.setOut(capture);

        ConsoleHangman ConsoleHangMan = new ConsoleHangman("r");
        ConsoleHangMan.game("obstacle");

        capture.flush();
        consoleOutput = outputStream.toString();

        assertEquals("> Missed, mistake 1 out of 5.\n"
            + ">\n" + "> The word: [*, *, *, *, *, *, *, *]", consoleOutput.substring(21, 89));
    }

    @Test
    @DisplayName("Проверка, что состояние игры корректно изменяется при неугадывании №2")
    void test4() {
        String consoleOutput;
        PrintStream originalOut = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(100);
        PrintStream capture = new PrintStream(outputStream);
        System.setOut(capture);

        ConsoleHangman ConsoleHangMan = new ConsoleHangman("e\nx");
        ConsoleHangMan.game("heaven");

        capture.flush();
        consoleOutput = outputStream.toString();

        assertEquals(
            "[*, e, *, *, e, *]->[*, e, *, *, e, *]",
            consoleOutput.substring(42, 60) + "->" + consoleOutput.substring(128, 146)
        );
    }

    @Test
    @DisplayName("Проверка, что состояние игры корректно изменяется при угадывании №1")
    void test5() {
        String consoleOutput;
        PrintStream originalOut = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(100);
        PrintStream capture = new PrintStream(outputStream);
        System.setOut(capture);

        ConsoleHangman ConsoleHangMan = new ConsoleHangman("c");
        ConsoleHangMan.game("obstacle");

        capture.flush();
        consoleOutput = outputStream.toString();
        assertEquals("> Hit!\n" + ">\n" + "> The word: [*, *, *, *, *, c, *, *]", consoleOutput.substring(21, 66));
    }

    @Test
    @DisplayName("Проверка, что состояние игры корректно изменяется при угадывании №2")
    void test6() {
        String consoleOutput;
        PrintStream originalOut = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(100);
        PrintStream capture = new PrintStream(outputStream);
        System.setOut(capture);

        ConsoleHangman ConsoleHangMan = new ConsoleHangman("l\ne");
        ConsoleHangMan.game("employee");

        capture.flush();
        consoleOutput = outputStream.toString();
        assertEquals(
            "[*, *, *, l, *, *, *, *]->[e, *, *, l, *, *, e, e]",
            consoleOutput.substring(42, 66) + "->" + consoleOutput.substring(111, 135)
        );
    }

    @Test
    @DisplayName("Проверка, что при отгадывании ввод строки длиной больше чем 1 (опечатка) " +
        "приводит к повторному вводу, без изменения состояния")
    void test7() {
        String consoleOutput;
        PrintStream originalOut = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(100);
        PrintStream capture = new PrintStream(outputStream);
        System.setOut(capture);

        ConsoleHangman ConsoleHangMan = new ConsoleHangman("cngk");
        ConsoleHangMan.game("obstacle");

        capture.flush();
        consoleOutput = outputStream.toString();

        assertEquals("> Write correct letter!", consoleOutput.substring(21, 44));
    }
}
