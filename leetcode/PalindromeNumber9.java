package leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Given an integer x, return true if x is a palindrome, and false otherwise.
 */
public class PalindromeNumber9 {
    public static void main(String[] args) {
        System.out.println(isPalindrome(1211));
    }

    private static boolean isPalindrome(int x) {
        if (x < 0 || (x != 0 && x % 10 == 0)) return false;
        int rev = 0;
        while (x > rev) {
            rev = rev * 10 + x % 10;
            x = x / 10;
        }
        return (x == rev || x == rev / 10);
    }

//    private static boolean isPalindrome(int x) {
//        String s = String.valueOf(x);
//        return s.equals(new StringBuilder(s).reverse().toString());
//    }
}
