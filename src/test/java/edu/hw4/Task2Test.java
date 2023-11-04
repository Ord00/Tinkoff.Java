package edu.hw4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Task2Test {
    @Test
    @DisplayName("Проверка сортировки по весу с заполненным списком и корректным кол-вом сортируемых элементов")
    void CorrectList() {
        ArrayList<Animal> list = new ArrayList<>();
        list.add(new Animal("Thunder", Animal.Type.DOG, Animal.Sex.M, 6, 35, 10, true));
        list.add(new Animal("Majesty", Animal.Type.FISH, Animal.Sex.F, 2, 3, 21, false));
        list.add(new Animal("Eagle", Animal.Type.BIRD, Animal.Sex.M, 10, 7, 9, false));
        list.add(new Animal("Mr. Cat", Animal.Type.CAT, Animal.Sex.M, 1, 89, 17, true));
        String actual = Task2.sortByWeight(list, 2).toString();
        String expected = "[Majesty, Mr. Cat]";
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Проверка сортировки по весу с заполненным списком и отрицательным кол-вом сортируемых элементов")
    void NegativeKCheck() {
        ArrayList<Animal> list = new ArrayList<>();
        list.add(new Animal("Thunder", Animal.Type.DOG, Animal.Sex.M, 6, 35, 10, true));
        list.add(new Animal("Majesty", Animal.Type.FISH, Animal.Sex.F, 2, 3, 21, false));
        list.add(new Animal("Eagle", Animal.Type.BIRD, Animal.Sex.M, 10, 7, 9, false));
        list.add(new Animal("Mr. Cat", Animal.Type.CAT, Animal.Sex.M, 1, 89, 17, true));
        String actual = Task2.sortByWeight(list, -9).toString();
        String expected = "[]";
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Проверка сортировки по весу с заполненным списком и нулевым кол-вом сортируемых элементов")
    void ZeroKCheck() {
        ArrayList<Animal> list = new ArrayList<>();
        list.add(new Animal("Thunder", Animal.Type.DOG, Animal.Sex.M, 6, 35, 10, true));
        list.add(new Animal("Majesty", Animal.Type.FISH, Animal.Sex.F, 2, 3, 21, false));
        list.add(new Animal("Eagle", Animal.Type.BIRD, Animal.Sex.M, 10, 7, 9, false));
        list.add(new Animal("Mr. Cat", Animal.Type.CAT, Animal.Sex.M, 1, 89, 17, true));
        String actual = Task2.sortByWeight(list, 0).toString();
        String expected = "[]";
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Проверка сортировки по весу с заполненным списком и числом, превышающим кол-во элементов в списке")
    void OversizeKCheck() {
        ArrayList<Animal> list = new ArrayList<>();
        list.add(new Animal("Thunder", Animal.Type.DOG, Animal.Sex.M, 6, 35, 10, true));
        list.add(new Animal("Majesty", Animal.Type.FISH, Animal.Sex.F, 2, 3, 21, false));
        list.add(new Animal("Eagle", Animal.Type.BIRD, Animal.Sex.M, 10, 7, 9, false));
        list.add(new Animal("Mr. Cat", Animal.Type.CAT, Animal.Sex.M, 1, 89, 17, true));
        String actual = Task2.sortByWeight(list, 50).toString();
        String expected = "[Majesty, Mr. Cat, Thunder, Eagle]";
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Проверка сортировки по весу на 'null' значении")
    void NullList() {
        assertThrows(NullPointerException.class, () -> Task2.sortByWeight(null, 0).toString());
    }

    @Test
    @DisplayName("Проверка сортировки по весу на пустом списке")
    void EmptyList() {
        ArrayList<Animal> list = new ArrayList<>();
        String actual = Task2.sortByWeight(list, 7).toString();
        String expected = "[]";
        assertEquals(expected, actual);
    }
}
