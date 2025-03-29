package com.leetcode.Easy;

public class RemoveElement {

    /**
     * Removes all occurrences of val in nums in-place.
     * The order of the elements may be changed.
     *
     * @param nums The input integer array.
     * @param val  The integer value to be removed from the array.
     * @return The count of elements in nums that are not equal to val.
     */
    public int removeElement(int[] nums, int val) {
        int count = 0;
        int last = nums.length;

        // Iterate through the array
        for (int i = 0; i < last; i++) {
            if (nums[i] == val) {  // Found an occurrence of val
                count++;
                nums[i] = nums[last - 1];  // Replace it with the last valid element
                i--;  // Recheck the current index
                last--;  // Reduce the effective array size
            }
        }

        return nums.length - count; // Return the number of elements that are not val
    }

}
