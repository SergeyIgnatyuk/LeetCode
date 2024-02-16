package stream;

import java.util.AbstractMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Дана строка. Палиндром - это строка, которая читается одинаково как с начала, так и с конца.
 * Необходимо написать программу на Java с использованием Stream API для поиска всех подстрок в строке, которые являются палиндромами.
 */
public class PalindromeSubstringFinder {

    public static void main(String[] args) {
        String input = "abcbadefdedxyzzyxdetrewert";
        Map<Integer, String> substrings = IntStream
                .range(0, input.length())
                .mapToObj(i ->  new AbstractMap.SimpleImmutableEntry<>(i, String.valueOf(input.toCharArray()[i])))
                .collect(Collectors.toMap(AbstractMap.SimpleImmutableEntry::getKey, AbstractMap.SimpleImmutableEntry::getValue));
    }
}
