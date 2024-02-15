package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * You are visiting a farm that has a single row of fruit trees arranged from left to right.
 * The trees are represented by an integer array fruits where fruits[i] is the type of fruit the ith tree produces.
 * You want to collect as much fruit as possible. However, the owner has some strict rules that you must follow:
 * You only have two baskets, and each basket can only hold a single type of fruit. There is no limit on the amount of fruit each basket can hold.
 * Starting from any tree of your choice, you must pick exactly one fruit from every tree (including the start tree) while moving to the right.
 * The picked fruits must fit in one of your baskets.
 * Once you reach a tree with fruit that cannot fit in your baskets, you must stop.
 * Given the integer array fruits, return the maximum number of fruits you can pick.
 */
public class FruitIntoBaskets904 {
    public static void main(String[] args) {
        int[] fruits = {0,1,2,2};
        System.out.println(totalFruit(fruits));
    }

    private static int totalFruit(int[] fruits) {
        int totalFruit = 0;
        List<Integer> totals = new ArrayList<>();
        int firstBasketCount = 0;
        int secondBasketCount = 0;
        int basket1 = 0;
        int basket2 = 0;

        for (int i = 0; i < fruits.length; ) {
            if (basket1 == fruits[i] || basket2 == fruits[i]) {
                if (basket1 == fruits[i]) {
                    firstBasketCount++;
                    secondBasketCount = 0;
                } else {
                    firstBasketCount = 0;
                    secondBasketCount++;
                }
                totalFruit++;
                i++;
            } else {
                if (basket1 != fruits[i] && firstBasketCount == 0) {
                    basket1 = fruits[i];
                    firstBasketCount++;
                    secondBasketCount = 0;
                } else if (basket2 != fruits[i] && secondBasketCount == 0) {
                    basket2 = fruits[i];
                    secondBasketCount++;
                    firstBasketCount = 0;
                }
                if (i > 1) {
                    totalFruit = 0;
                } else {
                    i++;
                    totalFruit++;
                }
            }
            totals.add(totalFruit);
        }
        System.out.println(totals);
        return totals.stream().mapToInt(i -> i).max().orElse(0);
    }
}
