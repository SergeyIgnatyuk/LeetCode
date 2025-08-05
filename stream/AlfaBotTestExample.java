package stream;

import java.util.stream.Stream;

public class AlfaBotTestExample {
    public static void main(String[] args) {
        Stream.of("a", "b", "c", "d")
                .map(element -> {
                    System.out.println(STR."map: \{element}");
                    return element.toUpperCase();
                })
                .anyMatch(upperCaseElement -> {
                    System.out.println(STR."anyMatch: \{upperCaseElement}");
                    return upperCaseElement.contains("A");
                });
    }


}
