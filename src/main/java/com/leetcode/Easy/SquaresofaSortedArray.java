package com.leetcode.Easy;

public class SquaresofaSortedArray {

    /**
     * Function to return an array of the squares of each number in the input array,
     * sorted in non-decreasing order.
     *
     * Approach: We use two pointers (left and right) to process the array in reverse order.
     * Since the array is already sorted, we can use a two-pointer approach to fill the result
     * array from right to left by comparing the absolute values of elements at the left and right.
     *
     * @param nums the input array of integers sorted in non-decreasing order
     * @return an array of the squares of each number, sorted in non-decreasing order
     */
    public int[] sortedSquares(int[] nums) {
        // Initialize left pointer at the beginning and right pointer at the end of the array
        int left = 0;
        int right = nums.length - 1;

        // Create an array to store the squares of the elements
        int[] arr = new int[nums.length];

        // Position to insert the squared value, starting from the rightmost position
        int pos = right;

        // Process the array from the left and right ends
        while (left <= right) {
            // Compare the absolute values of elements at the left and right
            if (Math.abs(nums[left]) > Math.abs(nums[right])) {
                // Square the element at the left pointer and place it at the current position
                arr[pos] = nums[left] * nums[left];
                left++;  // Move the left pointer to the right
            } else {
                // Square the element at the right pointer and place it at the current position
                arr[pos] = nums[right] * nums[right];
                right--;  // Move the right pointer to the left
            }
            pos--;  // Move to the next position from the right to left
        }

        // Return the array with the sorted squares
        return arr;
    }

}
