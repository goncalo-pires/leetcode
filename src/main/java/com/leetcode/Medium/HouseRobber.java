package com.leetcode.Medium;

import java.util.HashMap;

public class HouseRobber {

    // HashMap to store the computed results for each house index (memoization)
    private final HashMap<Integer, Integer> valuesList = new HashMap<>();

    /**
     * Public method to start the robbery process from the last house.
     *
     * @param nums the array of integers representing the amount of money in each house
     * @return the maximum amount of money that can be robbed
     */
    public int rob(int[] nums) {
        return rob(nums, nums.length - 1);  // Start from the last house
    }

    /**
     * Recursive helper method to compute the maximum money that can be robbed up to the ith house.
     *
     * @param nums the array of integers representing the amount of money in each house
     * @param i the current house index to be considered
     * @return the maximum money that can be robbed up to the ith house
     */
    private int rob(int[] nums, int i) {
        // Base case: If there are no houses to rob (i < 0), return 0
        if (i < 0) return 0;

        // If we have already computed the result for this house, return the stored value
        if (valuesList.containsKey(i)) {
            return valuesList.get(i);
        }

        // Recursive case:
        // The robber can either rob this house and skip the previous one (i-2) or skip this house and rob the previous one (i-1)
        int max = Math.max(rob(nums, i - 2) + nums[i], rob(nums, i - 1));

        // Store the result for house i in the memoization map
        valuesList.put(i, max);

        return max;
    }

}