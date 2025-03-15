package com.leetcode.Medium;

import java.util.LinkedList;
import java.util.Queue;

public class MaxConsecutivesOnesIII {

    /**
     * Function to find the maximum number of consecutive 1's in a binary array
     * by flipping at most `k` 0's to 1's.
     *
     * Approach: This problem can be solved using the sliding window (or two-pointer) technique.
     * We will keep a window of elements that contains at most `k` zeroes.
     * As we iterate through the array, we adjust the window size dynamically to ensure that
     * it contains at most `k` zeroes, and we update the maximum length of the window
     * that meets this condition.
     *
     * @param nums the input binary array consisting of 0's and 1's
     * @param k the maximum number of 0's we can flip to 1's
     * @return the maximum length of a contiguous subarray of 1's after flipping at most `k` 0's
     */
    public int longestOnes(int[] nums, int k) {
        // Initialize variables
        int max = 0;      // Stores the maximum length of 1's after flipping at most k 0's
        int sum = 0;      // Tracks the current window size
        Queue<Integer> indexes = new LinkedList<>();  // Stores the indexes of flipped 0's

        // Iterate through the array to find the longest subarray
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                sum++;  // Increase the window size when encountering a 1
            } else {
                indexes.add(i);  // Add the index of the 0
                if (indexes.size() > k) {
                    // If there are more than k 0's in the window, shrink the window
                    sum = i - indexes.poll();  // Remove the leftmost 0's index and adjust window size
                } else {
                    // Include the 0 in the window (flip it to 1)
                    sum++;
                }
            }
            // Update the maximum window size
            max = Math.max(max, sum);
        }

        // Return the maximum length of the subarray with at most k flipped 0's
        return max;
    }

}
