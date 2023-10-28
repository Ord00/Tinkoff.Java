package edu.hw3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

@SuppressWarnings({"RegexpSinglelineJava", "uncommentedmain"})
public class Task5 {
    private Task5() {

    }

    public static class MyStandartComparator implements Comparator {
        @Override
        public int compare(Object o1, Object o2) {
            String s1 = o1.toString();
            int delim1 = s1.indexOf(' ');
            String s2 = o2.toString();
            int delim2 = s2.indexOf(' ');
            if (delim1 != -1) {
                s1 = s1.substring(delim1 + 1);
            }
            if (delim2 != -1) {
                s2 = s2.substring(delim2 + 1);
            }
            return s1.compareTo(s2);
        }
    }

    public static class MyReverseComparator implements Comparator {
        @Override
        public int compare(Object o1, Object o2) {
            String s1 = o1.toString();
            int delim1 = s1.indexOf(' ');
            String s2 = o2.toString();
            int delim2 = s2.indexOf(' ');
            if (delim1 != -1) {
                s1 = s1.substring(delim1 + 1);
            }
            if (delim2 != -1) {
                s2 = s2.substring(delim2 + 1);
            }
            return s2.compareTo(s1);
        }
    }

    public static ArrayList<String> parseContacts(ArrayList<String> source, String sortType) {
        ArrayList<String> result = source;
        if (result != null) {
            if (sortType.equals("ASC")) {
                Collections.sort(result, new MyStandartComparator());
            } else if (sortType.equals("DESC")) {
                Collections.sort(result, new MyReverseComparator());
            } else {
                return new ArrayList<>();
            }
        } else {
            return new ArrayList<>();
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String name;
        System.out.print("Введите кол-во элементов массива имён: ");
        int size = in.nextInt();
        ArrayList<String> source = new ArrayList<>(size);
        System.out.println("Введите элементы массива имён!");
        in.nextLine();
        for (int i = 0; i < size; ++i) {
            System.out.print(String.format("Введите %d-е имя: ", i + 1));
            name = in.nextLine();
            source.add(name);
        }
        System.out.print("Введите тип сортировки (по возрастанию/убыванию (ASC/DESC)): ");
        String sortType = in.nextLine();
        System.out.println("Отсортированный массив: " + parseContacts(source, sortType));
    }
}
