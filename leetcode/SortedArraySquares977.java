package leetcode;

import java.util.Arrays;

/**
 * Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.
 */
public class SortedArraySquares977 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortedSquares(new int[]{-4,-1,0,3,10})));;
    }

    public static int[] sortedSquares(int[] nums) {
        return Arrays.stream(nums).map(i -> i*i).sorted().toArray();
    }
}
