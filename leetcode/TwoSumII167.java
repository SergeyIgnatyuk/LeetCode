package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order, find two numbers such that they add up to a specific target number.
 * Let these two numbers be numbers[index1] and numbers[index2] where 1 <= index1 < index2 <= numbers.length.
 * Return the indices of the two numbers, index1 and index2, added by one as an integer array [index1, index2] of length 2.
 * The tests are generated such that there is exactly one solution. You may not use the same element twice.
 * Your solution must use only constant extra space.
 */
public class TwoSumII167 {
    public static void main(String[] args) {
        int[] numbers = {2,7,11,15};
        int target = 9;
        System.out.println(Arrays.toString(defineIndices(numbers, target)));
    }

    private static int[] defineIndices(int[] numbers, int target) {
        Map<Integer, Integer> numToIndex = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            if (numToIndex.containsKey(target - numbers[i])) {
                return new int[] {numToIndex.get(target - numbers[i]) + 1, i + 1};
            }
            numToIndex.put(numbers[i], i);
        }
        return new int[] {};
    }
}
