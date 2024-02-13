package single_number;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
 *
 * You must implement a solution with a linear runtime complexity and use only constant extra space.
 */

public class SingleNumber {
    public static void main(String[] args) {
        int[] nums = new int[]{2,2,1};
        System.out.println(singleNumber(nums));
    }

    public static int singleNumber(int[] nums) {
        List<Integer> sortedDistinctList = Arrays.stream(nums).distinct().boxed().toList();
        List<Integer> duplicates = new ArrayList<>(Arrays.stream(nums).boxed().toList());
        duplicates.removeAll(sortedDistinctList);

        System.out.println(duplicates);

        List<Integer> singleNumberList = new ArrayList<>(Arrays.stream(nums).boxed().toList());
        singleNumberList.removeAll(duplicates);
        return singleNumberList.get(0);
    }
}
