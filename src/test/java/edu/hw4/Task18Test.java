package edu.hw4;

import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class Task18Test {
    @Test
    @DisplayName("Проверка поиска самой тяжелой рыбки в 2-х или более списках в корректном списке")
    void CorrectList() {
        ArrayList<Animal> list1 = new ArrayList<>();
        list1.add(new Animal("Eagle", Animal.Type.BIRD, Animal.Sex.F, 10, 7, 9, false));
        list1.add(new Animal("Maven", Animal.Type.BIRD, Animal.Sex.M, 111, 78, 19, true));
        list1.add(new Animal("Frog", Animal.Type.BIRD, Animal.Sex.F, 10, 7, 9, false));
        list1.add(new Animal("Majesty", Animal.Type.FISH, Animal.Sex.M, 2, 3, 21, false));
        list1.add(new Animal("Thunder", Animal.Type.FISH, Animal.Sex.F, 4, 235, 10, true));
        list1.add(new Animal("Mr. Cat", Animal.Type.FISH, Animal.Sex.M, 4, 189, 17, true));

        List<List<Animal>> lists = getLists(list1);

        String actual = Task18.theHeaviestFish(lists).toString();
        String expected = "Optional[Evidence]";
        assertEquals(expected, actual);
    }

    @NotNull private static List<List<Animal>> getLists(ArrayList<Animal> list1) {
        ArrayList<Animal> list2 = new ArrayList<>();
        list2.add(new Animal("Spectator", Animal.Type.SPIDER, Animal.Sex.F, 10, 7, 9, false));
        list2.add(new Animal("Destination", Animal.Type.CAT, Animal.Sex.M, 111, 78, 19, true));
        list2.add(new Animal("Property", Animal.Type.BIRD, Animal.Sex.F, 10, 7, 9, false));
        list2.add(new Animal("Evidence", Animal.Type.FISH, Animal.Sex.M, 2, 3, 56, false));
        list2.add(new Animal("Milk", Animal.Type.FISH, Animal.Sex.F, 4, 235, 4, true));
        list2.add(new Animal("Chemistry", Animal.Type.FISH, Animal.Sex.M, 4, 189, 30, true));

        List<List<Animal>> lists = Arrays.asList(list1, list2);
        return lists;
    }

    @Test
    @DisplayName("Проверка поиска самой тяжелой рыбки в 2-х или более списках на 'null' значении")
    void NullList() {
        assertThrows(NullPointerException.class, () -> Task18.theHeaviestFish(null)).toString();
    }

    @Test
    @DisplayName("Проверка поиска самой тяжелой рыбки в 2-х или более списках на пустом списке списков")
    void EmptyList() {
        List<List<Animal>> lists = new ArrayList<>();
        assertThrows(NullPointerException.class, () -> Task18.theHeaviestFish(lists)).toString();
    }
}

