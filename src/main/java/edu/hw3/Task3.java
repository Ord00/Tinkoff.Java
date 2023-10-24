package edu.hw3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

@SuppressWarnings({"RegexpSinglelineJava", "uncommentedmain"})
public class Task3 {
    private Task3() {

    }

    public static <T> String freqDict(List<T> list) {
        HashMap<T, Integer> hashMap = new HashMap<>();
        for (T i : list) {
            if (!hashMap.containsKey(i)) {
                hashMap.put(i, 1);
            } else {
                hashMap.put(i, hashMap.get(i) + 1);
            }
        }
        return hashMapToString(hashMap);
    }

    public static <T> String hashMapToString(HashMap<T, Integer> hashMap) {
        String result = "{";
        for (T i : hashMap.keySet()) {
            String key = i.toString();
            String value = hashMap.get(i).toString();
            result += key + ": " + value + ", ";
        }
        return result.substring(0, result.length() - 2) + "}";
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
        System.out.println("Частотный словарь: " + freqDict(list));
    }
}
