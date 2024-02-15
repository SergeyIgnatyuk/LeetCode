package stream;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**+
 * Дан список целочисленных значений и целевая сумма.
 * Необходимо написать программу на Java с использованием Stream API для нахождения всех уникальных пар чисел из списка, сумма которых равна заданной цели.
 */
public class PairSumFinder {
    public static void main(String[] args) {
        Integer[] numbers = {2, 4, 3, 5, 7, 8, 9};
        int targetSum = 12;
        Set<String> pairs = new HashSet<>(Arrays.asList(numbers)).stream()
                .flatMap(i -> new HashSet<>(Arrays.asList(numbers)).stream()
                        .filter(j -> i + j == targetSum && !i.equals(j))
                        .map(j -> "(" + i + ", " + j + ")"))
                .collect(Collectors.toSet());
        System.out.println(pairs);
    }
}
