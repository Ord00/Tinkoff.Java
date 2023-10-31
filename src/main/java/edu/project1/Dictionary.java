package edu.project1;

import java.util.Random;
import org.jetbrains.annotations.NotNull;

public class Dictionary {
    private Dictionary() {

    }

    final static int THREE = 3;

    @NotNull public static String randomWord() {
        Random random = new Random();
        String result = switch (random.nextInt(THREE)) {
            case 0 -> "hello";
            case 1 -> "obstacle";
            default -> "predicament";
        };
        return result;
    }
}
