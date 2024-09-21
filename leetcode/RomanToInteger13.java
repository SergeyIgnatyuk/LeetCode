package leetcode;

import java.util.Map;

/**
 * Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII.
 * Instead, the number four is written as IV. Because the one is before the five we subtract it making four.
 * The same principle applies to the number nine, which is written as IX.
 */
public class RomanToInteger13 {
    public static void main(String[] args) {
        String roman = "MCMXCIV";
        System.out.println(romanToInt(roman));
    }

    public static int romanToInt(String s) {
        Map<String, Integer> romanToInt = Map.of(
                "I", 1,
                "V", 5,
                "X", 10,
                "L", 50,
                "C", 100,
                "D", 500,
                "M", 1000
        );

        int result = 0;
        int target = Integer.MIN_VALUE;

        for (int i = s.length() - 1; i >= 0; i--) {
            int val = romanToInt.get(String.valueOf(s.charAt(i)));
            if (val >= target) {
                result += val;
                target = val;
            } else {
                result -= val;
            }
        }
        return result;
    }

}
