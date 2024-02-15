package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * You are given a string s. We want to partition the string into as many parts as possible so that each letter appears in at most one part.
 * <p>
 * Note that the partition is done so that after concatenating all the parts in order, the resultant string should be s.
 * <p>
 * Return a list of integers representing the size of these parts.
 */
public class PartitionLabels763 {
    public static void main(String[] args) {
        System.out.println(partitionLabels("vhaagbqkaq"));
    }

    public static List<Integer> partitionLabels(String s) {
        List<Integer> result = new ArrayList<>();
        char[] charArray = s.toCharArray();
        int firstCursor = 0;
        int secondCursor = s.lastIndexOf(charArray[0]);
        for (int i = 0; i < charArray.length; i++) {
            if (secondCursor == charArray.length - 1) {
                result.add(s.substring(firstCursor, charArray.length).length());
                break;
            }
            if (i > secondCursor && secondCursor < s.lastIndexOf(charArray[i])) {
                result.add(s.substring(firstCursor, secondCursor + 1).length());
                firstCursor = i;
                secondCursor = s.lastIndexOf(charArray[i]);
                if (i == charArray.length - 1) {
                    result.add(String.valueOf(charArray[i]).length());
                }

            } else if (i < secondCursor && secondCursor < s.lastIndexOf(charArray[i])) {
                secondCursor = s.lastIndexOf(charArray[i]);
            }
        }
        return result;
    }
}
