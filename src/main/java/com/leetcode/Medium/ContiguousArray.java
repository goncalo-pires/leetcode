package com.leetcode.Medium;

public class ContiguousArray {

    /**
     * Function to find the maximum length of a contiguous subarray with an equal number of 0 and 1.
     *
     * The approach is based on using a cumulative sum to track the balance between 0s and 1s in the array.
     * Every 0 is replaced by -1 to simplify the problem to finding subarrays with a sum of 0. The function
     * uses an auxiliary array to store the first occurrence of each cumulative sum.
     * If the same cumulative sum is encountered again, it means the subarray between the previous occurrence
     * and the current index has an equal number of 0s and 1s.
     *
     * @param nums the binary array containing 0s and 1s
     * @return the maximum length of a contiguous subarray with an equal number of 0 and 1
     */
    public static int findMaxLength(int[] nums) {
        // Array to store the first occurrence index of each cumulative sum
        int[] arr = new int[nums.length * 2 + 1];
        int max = 0;
        int sum = nums.length; // Initial sum adjusted to ensure 0 sum is handled correctly

        for (int i = 0; i < nums.length; i++) {
            // Convert 0 to -1 to simplify the sum calculation
            if (nums[i] == 0) nums[i] = -1;

            // Update the cumulative sum
            sum += nums[i];

            // If the sum is 0 at this index, the subarray from 0 to i is valid
            if (sum == nums.length) {
                max = i + 1;
                continue;
            }

            // Check if we've encountered this sum before; if so, calculate the length of the subarray
            if (arr[sum] != 0) {
                max = Math.max(max, i - arr[sum] + 1);
            } else {
                // Store the first occurrence of the cumulative sum
                arr[sum] = i + 1;
            }
        }
        return max; // Return the maximum length of the subarray with equal 0s and 1s
    }

}
