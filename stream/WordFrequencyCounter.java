package stream;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Дан список строк, представляющих собой текстовый документ.
 * Необходимо написать программу на Java с использованием Stream API для подсчета частоты встречаемости каждого слова в тексте.
 */
public class WordFrequencyCounter {
    public static void main(String[] args) {
        String[] lines = {
                "Hello world",
                "Hello Java",
                "Stream API is powerful",
                "Java Stream API"
        };

        Map<String, Long> wordFrequency  = Arrays.stream(lines)
                .flatMap(s -> Arrays.stream(s.split("\\s+")))
                .collect(Collectors.groupingBy(String::toLowerCase, Collectors.counting()));

        System.out.println(wordFrequency);
    }
}
