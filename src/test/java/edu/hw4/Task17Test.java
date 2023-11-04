package edu.hw4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class Task17Test {
    @Test
    @DisplayName("Проверка, что пауки кусаются чаще, чем собаки в корректном списке (собаки и пауки есть)")
    void CorrectListWithSpidersAndDogs() {
        ArrayList<Animal> list = new ArrayList<>();
        list.add(new Animal("Thunder", Animal.Type.DOG, Animal.Sex.M, 4, 235, 10, true));
        list.add(new Animal("Majesty", Animal.Type.SPIDER, Animal.Sex.F, 2, 3, 21, false));
        list.add(new Animal("Eagle", Animal.Type.SPIDER, Animal.Sex.M, 10, 7, 9, false));
        list.add(new Animal("Mr. Cat", Animal.Type.SPIDER, Animal.Sex.M, 4, 189, 17, true));
        list.add(new Animal("Maven", Animal.Type.DOG, Animal.Sex.M, 111, 78, 19, true));
        Boolean actual = Task17.isSpidersBiteMoreThanDogs(list);
        Boolean expected = false;
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Проверка, что пауки кусаются чаще, чем собаки в корректном списке (собаки и пауки отсутствуют)")
    void CorrectListWithoutRightDog() {
        ArrayList<Animal> list = new ArrayList<>();
        list.add(new Animal("Thunder", Animal.Type.CAT, Animal.Sex.M, 4, 235, 10, true));
        list.add(new Animal("Majesty", Animal.Type.FISH, Animal.Sex.F, 2, 3, 21, false));
        list.add(new Animal("Eagle", Animal.Type.BIRD, Animal.Sex.M, 10, 7, 9, false));
        list.add(new Animal("Mr. Cat", Animal.Type.CAT, Animal.Sex.M, 4, 189, 17, true));
        list.add(new Animal("Maven", Animal.Type.BIRD, Animal.Sex.M, 111, 78, 19, true));
        Boolean actual = Task17.isSpidersBiteMoreThanDogs(list);
        Boolean expected = false;
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Проверка eсть ли собака ростом более k см на 'null' значении")
    void NullList() {
        assertThrows(NullPointerException.class, () -> Task17.isSpidersBiteMoreThanDogs(null));
    }

    @Test
    @DisplayName("Проверка eсть ли собака ростом более k см на пустом списке")
    void EmptyList() {
        ArrayList<Animal> list = new ArrayList<>();
        Boolean actual = Task17.isSpidersBiteMoreThanDogs(list);
        Boolean expected = false;
        assertEquals(expected, actual);
    }
}
