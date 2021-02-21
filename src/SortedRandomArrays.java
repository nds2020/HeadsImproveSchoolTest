import java.util.Arrays;
import java.util.Random;

public class SortedRandomArrays {
    public static boolean isThereArrayWithSameLength(int[][] arrays, int length) {
        for (int[] array : arrays) {
            if (array == null) {
                return false;
            }

            if (array.length == length) {
                return true;
            }
        }

        return false;
    }

    public static int[][] generateSortedRandomArrays(int arraysCount) {
        final int MAX_ARRAYS_COUNT = 1001;

        if (arraysCount < 1 || arraysCount > MAX_ARRAYS_COUNT) {
            throw new IllegalArgumentException("Ошибка! Массивы не сгенерированы" + System.lineSeparator() +
                    arraysCount + " - недопустимое значение параметра" + System.lineSeparator() +
                    "Количество генерируемых массивов должно быть задано натуральным числом, не превышающим " + MAX_ARRAYS_COUNT);
        }

        int[][] generatedArrays = new int[arraysCount][];

        Random random = new Random();

        /* Генерируем пустые массивы случайных несовпадающих размеров и помещаем их в двумерный массив.
        Возможный размер каждого массива ограничили максимально допустимым количеством генерируемых массивов, уменьшенным на 1.*/

        for (int i = 0; i < generatedArrays.length; ) {
            int arrayLength = random.nextInt(MAX_ARRAYS_COUNT);

            if (isThereArrayWithSameLength(generatedArrays, arrayLength)) {
                continue;
            }

            generatedArrays[i] = new int[arrayLength];
            i++;
        }

        // Заполняем сгенерированные массивы случайными числами и сортируем массивы по возрастанию

        for (int i = 0; i < generatedArrays.length; i++) {
            for (int j = 0; j < generatedArrays[i].length; j++) {
                generatedArrays[i][j] = random.nextInt();
            }

            Arrays.sort(generatedArrays[i]);
        }

        // Разворачиваем массивы с четным индексом (но нечетным порядковым номером), чтобы они стали отсортированными по убыванию

        for (int i = 0; i < generatedArrays.length; i += 2) {
            for (int j = 0, k = generatedArrays[i].length - 1; j < k; j++, k--) {
                int temp = generatedArrays[i][j];
                generatedArrays[i][j] = generatedArrays[i][k];
                generatedArrays[i][k] = temp;
            }
        }

        return generatedArrays;
    }

    // Для проверки

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