package com.leetcode.Medium;

public class MinimumSizeSubarraySum {

    public int minSubArrayLen(int target, int[] nums) {
        if (nums.length == 0) return 0;

        int left = 0;
        int sum = 0;
        int minWindow = Integer.MAX_VALUE;

        for (int right=0; right < nums.length; right++) {
            sum += nums[right];

            while (sum >= target) {
                minWindow = Math.min(minWindow, right - left + 1);
                sum -= nums[left++];
            }

        }

        return minWindow > nums.length ? 0 : minWindow;
    }

}
