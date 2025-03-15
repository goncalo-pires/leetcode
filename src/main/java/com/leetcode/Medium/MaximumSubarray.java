package com.leetcode.Medium;

public class MaximumSubarray {

    /**
     * Function to find the subarray with the largest sum.
     *
     * @param nums the integer array
     * @return the largest sum of a contiguous subarray
     */
    public int maxSubArray(int[] nums) {
        int sum = 0;  // Current sum of the subarray
        int max = Integer.MIN_VALUE;  // Maximum sum found so far

        // Iterate through each number in the array
        for (int n : nums) {
            // If the current sum is negative, reset it to 0
            if (sum < 0) sum = 0;

            // Add the current number to the sum
            sum += n;

            // Update the maximum sum found so far
            max = Math.max(sum, max);
        }

        return max;
    }
}
