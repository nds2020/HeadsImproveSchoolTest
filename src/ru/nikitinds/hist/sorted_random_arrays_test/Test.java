package ru.nikitinds.hist.sorted_random_arrays_test;

import java.util.Arrays;

import static ru.nikitinds.hist.sorted_random_arrays.SortedRandomArrays.generateSortedRandomArrays;

public class Test {
    public static void main(String[] args) {
        try {
            int[][] randomArrays = generateSortedRandomArrays(50);

            System.out.println("Количество сгенерированных массивов: " + randomArrays.length);
            System.out.println("Размеры массивов:");

            for (int[] array : randomArrays) {
                System.out.println(array.length);
            }

            System.out.println();
            System.out.println("Массивы:");

            for (int i = 1; i <= randomArrays.length; i++) {
                System.out.println(i + ": " + Arrays.toString(randomArrays[i - 1]));
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}