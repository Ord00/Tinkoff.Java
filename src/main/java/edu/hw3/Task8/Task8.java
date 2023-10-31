package edu.hw3.Task8;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@SuppressWarnings({"RegexpSinglelineJava", "uncommentedmain"})
public class Task8 {
    private Task8() {

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Object symbol;
        System.out.print("Введите кол-во элементов списка: ");
        int size = in.nextInt();
        List<Object> list = new ArrayList<>(size);
        System.out.print("Введите элементы списка: ");
        for (int i = 0; i < size; ++i) {
            symbol = in.next();
            list.add(symbol);
        }
        BackwardIterator iterator = new BackwardIterator(Object.class, list);
        System.out.println("Коллекция в обратном порядке: " + iterator.toString());
    }
}
