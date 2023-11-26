package find_all_anagrams_in_a_string;

import java.util.*;

/**
 * Given two strings s and p, return an array of all the start indices of p's anagrams in s. You may return the answer in any order.
 *
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
 */

public class FindAllAnagrams {
    public static void main(String[] args) {
        System.out.println(findAnagrams("cbaebaaaacbabacd", "abc"));
    }

    public static List<String> findAnagrams(String s, String p) {
        List<String> list = new ArrayList<>();
        char[] pArray = p.toCharArray();
        char[] sArray = s.toCharArray();
        StringTokenizer tokenizer = new StringTokenizer(s, p);
        int startIndex = 0;
        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();
            String anagram = s.substring(startIndex, s.indexOf(token));
            if (anagram.length() == p.length()) {
                list.add(anagram);
            } else {
                int count = 0;
                for (int i = 0; i < pArray.length; i++) {
                    for (int j = 0; j < sArray.length; j++) {
                        if (pArray[i] == sArray[j]) {
                            count++;
                        }
                    }
                }
            }
            startIndex = s.indexOf(token) + 1;
        }
        return list;
    }
}
