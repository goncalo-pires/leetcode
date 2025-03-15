package com.leetcode.Medium;

import java.util.Arrays;

public class KRadiusSubarrayAverages {

    /**
     * Given an integer array nums and an integer k, return the k-radius averages of the subarrays
     * centered at each index of the array. The k-radius average for an index i is the average of
     * all elements in nums between the indices i - k and i + k (inclusive).
     * If there are less than k elements before or after index i, then the k-radius average is -1.
     *
     * @param nums The input array of integers.
     * @param k The radius for the average, i.e., how far to look left and right from each index.
     * @return An array of the k-radius averages for each index.
     */
    public int[] getAverages(int[] nums, int k) {
        // If k is 0, no averaging is needed; return the original array
        if (k == 0) {
            return nums;
        }

        // Calculate the size of the window for averaging
        int windowSize = 2 * k + 1;
        // Initialize the result array with -1, assuming no valid averages
        int[] arr = new int[nums.length];
        Arrays.fill(arr, -1);

        // If the window size is larger than the number of elements in nums, return the default array
        if (windowSize > nums.length) {
            return arr;
        }

        // Calculate the sum of the first window (from index 0 to windowSize-1)
        long sum = 0;
        for (int i = 0; i < windowSize; i++) {
            sum += nums[i];
        }

        // Assign the first valid average to the index k (center of the first window)
        arr[k] = (int) (sum / (k * 2 + 1));

        // Traverse the remaining indices and calculate the k-radius averages
        for (int i = k + 1; i < nums.length - k; i++) {
            // Adjust the sum by removing the element going out of the window and adding the element coming into the window
            sum = sum - nums[i - k - 1] + nums[i + k];
            // Store the average at the current index
            arr[i] = (int) (sum / windowSize);
        }

        return arr;
    }

}
