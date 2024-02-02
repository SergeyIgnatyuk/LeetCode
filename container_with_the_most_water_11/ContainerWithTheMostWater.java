package container_with_the_most_water_11;

/**
 * You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
 *
 * Find two lines that together with the x-axis form a container, such that the container contains the most water.
 */

public class ContainerWithTheMostWater {
    public static void main(String[] args) {
        int[] height = new int[]{1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
    }

    public static int maxArea(int[] height) {
        int maxWaterVolume = 0;
        int cursor = height.length - 1;
        for (int i = 0; i < height.length; i++) {
            for (int j = cursor; j > i; j--) {
                if (height[i] >= height[j]) {
                    maxWaterVolume = Math.max(height[j]*(j - i), maxWaterVolume);
                    continue;
                } if (height[i] < height[j]) {
                    cursor = j;
                    maxWaterVolume = Math.max(height[i]*(j - i), maxWaterVolume);
                    break;
                }
            }
        }
        return maxWaterVolume;
    }
}
