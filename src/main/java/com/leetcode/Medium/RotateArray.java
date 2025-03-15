package com.leetcode.Medium;

public class RotateArray {

    /**
     * Function to rotate an integer array to the right by k steps.
     * The rotation should be done in such a way that each element is shifted right by k positions,
     * and the elements that fall off the end are placed back at the start of the array.
     *
     * @param nums an array of integers
     * @param k the number of steps to rotate the array to the right
     */
    public void rotate(int[] nums, int k) {
        int n = nums.length;  // Get the length of the array

        // Handle cases where k is greater than the array length (because rotating by n or more is equivalent to rotating by k % n)
        k = k % n;

        // Create a new array to store the rotated values
        int[] rotated = new int[n];

        // Populate the rotated array with elements shifted by k positions
        for (int i = 0; i < n; i++) {
            rotated[(i + k) % n] = nums[i];  // The new index after rotation
        }

        // Copy the rotated array back into the original nums array
        System.arraycopy(rotated, 0, nums, 0, n);
    }

}
