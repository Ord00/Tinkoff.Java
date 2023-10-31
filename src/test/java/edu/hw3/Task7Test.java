package edu.hw3;

import edu.hw3.Task7.NullComparator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.TreeMap;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
public class Task7Test {
    @Test
    @DisplayName("Проверка добавления \"null\" значения")
    void checkComp() {
        TreeMap<String, String> tree = new TreeMap<>(new NullComparator());
        tree.put(null, "test");
        assertThat(tree.containsKey(null)).isTrue();
    }
}
