package edu.hw3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

@SuppressWarnings({"RegexpSinglelineJava", "uncommentedmain"})
public class Task3 {
    private Task3() {

    }

    public static <T> boolean checkList(List<T> list) {
        boolean result = true;
        int len = list.size();
        for (int i = 0; i < len - 1; ++i) {
            if (!list.get(i).getClass().equals(list.get(i + 1).getClass())) {
                result = false;
                break;
            }
        }
        return result;
    }

    public static <T> String freqDict(List<T> list) {
        if (checkList(list)) {
            HashMap<T, Integer> hashMap = new HashMap<>();
            for (T i : list) {
                if (!hashMap.containsKey(i)) {
                    hashMap.put(i, 1);
                } else {
                    hashMap.put(i, hashMap.get(i) + 1);
                }
            }
            return hashMapToString(hashMap);
        } else {
            return "Список содержит некорректные данные!";
        }
    }

    public static <T> String hashMapToString(HashMap<T, Integer> hashMap) {
        String result = "{";
        for (T i : hashMap.keySet()) {
            String key = i.toString();
            String value = hashMap.get(i).toString();
            if (i instanceof String) {
                result += "\"" + key + "\"" + ": " + value + ", ";
            } else {
                result += key + ": " + value + ", ";
            }
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
