package leetcode;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.
 */

public class ContainsDuplicate217 {
    public static void main(String[] args) {
        int[] nums = {1,3,4,1};
        System.out.println(containsDuplicate(nums));
    }

    public static boolean containsDuplicate(int[] nums) {
       return Arrays.stream(nums).distinct().toArray().length != nums.length;
    }
}
