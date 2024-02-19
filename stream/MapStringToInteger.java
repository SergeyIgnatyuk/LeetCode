package stream;

import java.util.List;
import java.util.stream.Collectors;

public class MapStringToInteger {
    public static void main(String[] args) {
        List<String> lines = List.of("1", "2", "3");
        List<Integer> numbers = lines.stream().map(Integer::parseInt).collect(Collectors.toList());
        System.out.println(numbers);
    }
}
