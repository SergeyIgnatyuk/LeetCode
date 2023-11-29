package jewels_and_stones;

import com.sun.source.doctree.SeeTree;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * You're given strings jewels representing the types of stones that are jewels, and stones representing the stones you have. Each character in stones is a type of stone you have. You want to know how many of the stones you have are also jewels.
 * <p>
 * Letters are case sensitive, so "a" is considered a different type of stone from "A".
 */
public class JewelsAndStones {
    public static void main(String[] args) {
        System.out.println(numJewelsInStones("aA", "aAAbbbb"));
    }

    public static int numJewelsInStones(String jewels, String stones) {
        int count = 0;
        for (char ch : stones.toCharArray()) {
            if (jewels.indexOf(ch) >= 0) {
                count++;
            }
        }
        return count;
    }
}
