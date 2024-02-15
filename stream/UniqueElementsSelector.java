package stream;

import java.util.Arrays;
import java.util.List;

/**
 * Дан список элементов.
 * Необходимо написать программу на Java с использованием Stream API для выборки уникальных элементов из списка.
 */
public class UniqueElementsSelector {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 1, 2, 3, 6, 7, 8, 9, 5);
        List<Integer> uniqueNumbers = numbers.stream().distinct().toList();
        System.out.println(uniqueNumbers);
    }
}
