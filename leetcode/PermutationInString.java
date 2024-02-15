package leetcode;

import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

/**
 * Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.
 * In other words, return true if one of s1's permutations is the substring of s2.
 */
public class PermutationInString {
    public static void main(String[] args) {
        System.out.println(checkInclusion("abc", "ccccbbbbaaaa"));
        String s1 = "abc";
        String s2 = "ccccbbbbaaaa";
        StringTokenizer tokenizer = new StringTokenizer(s2, s1);
        if (tokenizer.countTokens() >= 1) {
            while (tokenizer.hasMoreTokens()) {
                s2 = s2.replaceAll(tokenizer.nextToken(), ",");
            }
        }
        char[] chars1 = s1.toCharArray();
        Arrays.sort(chars1);
        String sortedS1 = new String(chars1);
        System.out.println(Arrays.stream(s2.split(","))
                .map(str -> {
                    return str.chars()
                            .distinct()
                            .sorted()
                            .mapToObj(c -> String.valueOf((char) c))
                            .collect(Collectors.joining());
                })
                .findFirst().orElse("Doesn't exist"));
    }

    public static boolean checkInclusion(String s1, String s2) {
        StringTokenizer tokenizer = new StringTokenizer(s2, s1);
        if (tokenizer.countTokens() >= 1) {
            while (tokenizer.hasMoreTokens()) {
                s2 = s2.replaceAll(tokenizer.nextToken(), ",");
            }
        }
        char[] chars1 = s1.toCharArray();
        Arrays.sort(chars1);
        String sortedS1 = new String(chars1);
        return Arrays.stream(s2.split(","))
                .map(str -> {
                    return str.chars()
                            .distinct()
                            .sorted()
                            .mapToObj(c -> String.valueOf((char) c))
                            .collect(Collectors.joining());
                }).anyMatch(sortedStr -> sortedStr.contains(sortedS1));
    }
}
