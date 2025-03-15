package com.leetcode.Easy;

import java.util.Arrays;

public class TwoSum {

    /**
     * Given an array of integers nums and an integer target, return indices of the two numbers
     * such that they add up to target.
     * You may assume that each input would have exactly one solution, and you may not use the same element twice.
     * You can return the answer in any order.
     *
     * @param nums the array of integers
     * @param target the target sum
     * @return the indices of the two numbers that add up to the target
     */
    public int[] twoSum(int[] nums, int target) {
        // Array to store the complement of each number we encounter
        Integer[] opposites = new Integer[nums.length];

        // Iterate through the array
        for (int i = 0; i < nums.length; i++) {
            // Check if the current number has its complement already in the opposites array
            int indexOf = Arrays.asList(opposites).indexOf(nums[i]);

            // If we find the complement, return the indices
            if (indexOf > -1) {
                return new int[]{indexOf, i};
            } else {
                // Otherwise, store the complement of the current number
                opposites[i] = target - nums[i];
            }
        }

        // Return an empty array if no solution is found
        return new int[0];
    }
}
