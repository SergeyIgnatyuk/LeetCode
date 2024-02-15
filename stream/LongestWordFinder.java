package stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Дан список строк.
 * Необходимо написать программу на Java с использованием Stream API для поиска самого длинного слова в списке.
 */
public class LongestWordFinder {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("apple", "banana", "grapefruit", "orange", "kiwi", "pineapple");
        String longestWord = words.stream().max(Comparator.comparingInt(String::length)).orElse(null);
        System.out.println(longestWord);
    }
}
