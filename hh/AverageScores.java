package hh;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AverageScores {

    public static List<String> printCorrectCandidates(String scoresInput, String namesInput) {
        List<String> result = new ArrayList<>();
        String delimiter = ",";
        int[] scores = Arrays.stream(scoresInput.split(delimiter)).mapToInt(Integer::parseInt).toArray();
        boolean isAboveAverageExists = Arrays.stream(scores).distinct().toArray().length > 1;
        if (isAboveAverageExists) {
            int average = (int) Arrays.stream(scores).average().orElseThrow();
            System.out.println(STR."Average score is \{average}\n");
            String[] names = namesInput.split(delimiter);
            for (int i = 0; i < names.length; i++) {
                if (scores[i] > average) result.add(names[i]);
            }
        } else {
            System.out.println("нет");
        }

        return result;
    }

    public static void main(String[] args) {
        List<String> result = printCorrectCandidates("1,2,3,4,5,6,7,8", "Петя,Саша,Маша,Света,Вова,Лена,Коля,Наташа");
        result.forEach(System.out::println);
    }
}
