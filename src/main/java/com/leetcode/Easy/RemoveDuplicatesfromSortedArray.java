package com.leetcode.Easy;

public class RemoveDuplicatesfromSortedArray {

    /**
     * Removes duplicates from a sorted integer array in-place.
     *
     * @param nums An integer array sorted in non-decreasing order.
     * @return The number of unique elements after removing duplicates.
     */
    public int removeDuplicates(int[] nums) {
        // Variable to track the number of duplicate elements encountered
        int shift = 0;

        // Iterate through the array starting from the second element
        for (int i = 1; i < nums.length; i++) {
            // If the current element is the same as the previous one, increase shift count
            if (nums[i] == nums[i - 1]) {
                shift++;
            } else {
                // Move the unique element to its correct position (excluding duplicates)
                nums[i - shift] = nums[i];
            }
        }

        // Return the count of unique elements
        return nums.length - shift;
    }

}
