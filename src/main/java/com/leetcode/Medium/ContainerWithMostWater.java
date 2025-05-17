package com.leetcode.Medium;

public class ContainerWithMostWater {

    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;

        while (left < right) {
            int l = height[left];
            int r = height[right];

            maxArea = Math.max(maxArea, Math.min(l, r) * (right - left));

            if (r < l) right--;
            else left++;

        }

        return maxArea;
    }

}
