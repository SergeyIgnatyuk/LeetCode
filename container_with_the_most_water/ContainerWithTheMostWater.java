package container_with_the_most_water;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

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
