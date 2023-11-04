package edu.hw4;

import java.util.List;

public class Task13 {
    private Task13() {

    }

    public static List<Animal> weightMoreHeight(List<Animal> animalList) {
        return animalList.stream().filter(i -> countWordsInString(i.name()) > 2).toList();
    }

    private static Integer countWordsInString(String s) {
        Integer result = 0;
        if (!s.isEmpty()) {
            ++result;
            int len = s.length();
            for (int i = 0; i < len; ++i) {
                if (s.charAt(i) == ' ') {
                    ++result;
                }
            }
        }
        return result;
    }
}
