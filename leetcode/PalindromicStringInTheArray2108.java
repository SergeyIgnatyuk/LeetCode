package leetcode;

/**
 * Given an array of strings words, return the first palindromic string in the array. If there is no such string, return an empty string "".
 * <p>
 * A string is palindromic if it reads the same forward and backward.
 */

public class PalindromicStringInTheArray2108 {
    public static void main(String[] args) {
        String[] words = {"abc", "car", "ada", "racecar", "cool"};
        System.out.println(findFirstPalindromicStringInTHeArray(words));

    }

    private static String findFirstPalindromicStringInTHeArray(String[] array) {
        String palindromicString = "";
        for (String word : array) {
            if (word.equals(new StringBuilder(word).reverse().toString())) {
                palindromicString = word;
                break;
            }
        }
        return palindromicString;
    }


//    private static String findFirstPalindromicStringInTHeArray(String[] array) {
//        String palindromicString = "";
//        for (String word : array) {
//            if (Objects.equals(word, new StringBuilder(word).reverse().toString())) {
//                palindromicString = word;
//                break;
//            }
//        }
//        return palindromicString;
//    }

//    private static String findFirstPalindromicStringInTHeArray(String[] array) {
//        return Arrays.stream(array)
//                .map(StringBuilder::new)
//                .filter(s -> Objects.equals(s.toString(), s.reverse().toString()))
//                .findFirst()
//                .map(StringBuilder::toString).orElse("");
//    }
}
