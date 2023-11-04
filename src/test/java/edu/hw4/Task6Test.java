package edu.hw4;

import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Task6Test {
    @Test
    @DisplayName("Проверка вывода самого тяжелого животного каждого вида с заполненным списком")
    void CorrectList() {
        ArrayList<Animal> list = getAnimals();
        Map<Animal.Type, Optional<Animal>> actual = Task6.theHeaviestAnimalsOfEveryType(list);
        Map<Animal.Type, Optional<Animal>> expected = new HashMap<>();
        expected.put(
            Animal.Type.DOG,
            Optional.of(new Animal("Thunder", Animal.Type.DOG, Animal.Sex.M, 6, 35, 10, true))
        );
        expected.put(
            Animal.Type.FISH,
            Optional.of(new Animal("Maverlous", Animal.Type.FISH, Animal.Sex.F, 2, 3, 21, false))
        );
        expected.put(
            Animal.Type.BIRD,
            Optional.of(new Animal("Eagle", Animal.Type.BIRD, Animal.Sex.M, 10, 7, 9, false))
        );
        expected.put(
            Animal.Type.CAT,
            Optional.of(new Animal("Mr. Cat", Animal.Type.CAT, Animal.Sex.M, 1, 89, 17, true))
        );
        assertEquals(expected, actual);
    }

    @NotNull private static ArrayList<Animal> getAnimals() {
        ArrayList<Animal> list = new ArrayList<>();
        list.add(new Animal("Murmur", Animal.Type.FISH, Animal.Sex.F, 1, 39, 8, false));
        list.add(new Animal("Thunder", Animal.Type.DOG, Animal.Sex.M, 6, 35, 10, true));
        list.add(new Animal("Maverlous", Animal.Type.FISH, Animal.Sex.F, 2, 3, 21, false));
        list.add(new Animal("Eagle", Animal.Type.BIRD, Animal.Sex.M, 10, 7, 9, false));
        list.add(new Animal("Mr. Cat", Animal.Type.CAT, Animal.Sex.M, 1, 89, 17, true));
        list.add(new Animal("Scratch", Animal.Type.FISH, Animal.Sex.M, 3, 1, 18, false));
        return list;
    }

    @Test
    @DisplayName("Проверка вывода самого тяжелого животного каждого вида на 'null' значении")
    void NullList() {
        assertThrows(NullPointerException.class, () -> Task6.theHeaviestAnimalsOfEveryType(null).toString());
    }

    @Test
    @DisplayName("Проверка вывода самого тяжелого животного каждого вида на пустом списке")
    void EmptyList() {
        assertThrows(
            NullPointerException.class,
            () -> Task6.theHeaviestAnimalsOfEveryType(new ArrayList<>()).toString()
        );
    }
}
