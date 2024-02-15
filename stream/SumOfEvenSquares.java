package stream;

import java.util.Arrays;
import java.util.List;

/**
 * Дан список целочисленных значений.
 * Необходимо написать программу на Java с использованием Stream API для вычисления суммы квадратов всех четных чисел из списка.
 */
public class SumOfEvenSquares {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        int sum = numbers.stream().filter(i -> i % 2 == 0).mapToInt(i -> i * i).sum();
        System.out.println(sum);
    }
}
