package find_all_anagrams_in_a_string;

import java.util.*;

/**
 * Given two strings s and p, return an array of all the start indices of p's anagrams in s. You may return the answer in any order.
 * <p>
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
 */

public class FindAllAnagrams {
    public static void main(String[] args) {
        System.out.println(findAnagrams("abab", "ab"));
    }

    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        char[] pArray = p.toCharArray();
        Arrays.sort(pArray);
        String sortedP = Arrays.toString(pArray);
        for (int i = 0; i < s.length(); i++) {
            if (i + p.length() <= s.length()) {
                String possibleAnagram = s.substring(i, i + p.length());
                char[] anagramArray = possibleAnagram.toCharArray();
                Arrays.sort(anagramArray);
                String sortedAnagram = Arrays.toString(anagramArray);
                if (sortedAnagram.equals(sortedP)) {
                    list.add(i);
                }
            }
        }
        return list;
    }
}
