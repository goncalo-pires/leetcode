package com.leetcode.Medium;

public class RemoveDuplicatesfromSortedArrayII {

    /**
     * Removes some duplicates from a sorted integer array in-place,
     * allowing each unique element to appear at most twice.
     *
     * @param nums An integer array sorted in non-decreasing order.
     * @return The number of elements remaining after removing extra duplicates.
     */
    public int removeDuplicates(int[] nums) {
        // Pointer 'valid' tracks the position for the next valid element
        int valid = 2;

        // Iterate through the array starting from the third element
        for (int i = 2; i < nums.length; i++) {
            // If nums[i] is different from nums[valid-2], it can be placed at nums[valid]
            if (nums[i] != nums[valid - 2]) {
                nums[valid] = nums[i];
                valid++; // Move to the next position
            }
        }

        // Return the length of the modified array with allowed duplicates
        return valid;
    }
}
