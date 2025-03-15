package com.leetcode.Easy;

public class MaximumAverageSubarrayI {

    /**
     * Function to find the maximum average of a contiguous subarray of length k.
     *
     * Given an integer array nums, and an integer k, this function finds the contiguous
     * subarray of length k with the maximum average value and returns it.
     *
     * We can do this using a sliding window technique, where we keep track of the sum of
     * the current window and adjust it as we move through the array.
     *
     * @param nums the integer array
     * @param k the length of the subarray
     * @return the maximum average value of a subarray of length k
     */
    public double findMaxAverage(int[] nums, int k) {
        int sum = 0;

        // Calculate the sum of the first 'k' elements
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }

        // Initialize 'max' to store the maximum sum found so far
        int max = sum;

        // Slide the window through the rest of the array
        for (int i = k; i < nums.length; i++) {
            // Subtract the element that is leaving the window and add the new element
            sum += nums[i] - nums[i - k];

            // Update the maximum sum if needed
            max = Math.max(max, sum);
        }

        // Return the maximum average, converting the sum to a double and dividing by k
        return (double) max / k;
    }

}
