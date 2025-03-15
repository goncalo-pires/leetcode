package com.leetcode.Easy;

public class MoveZeroes {

    /**
     * Function to move all zeros in the array to the end while maintaining the relative order of non-zero elements.
     * The function performs the task in-place, meaning it does not create a copy of the array.
     * It uses a variable to track the number of zeros encountered and swaps non-zero elements with the appropriate position.
     *
     * @param nums the input array where zeros need to be moved to the end
     */
    public void moveZeroes(int[] nums) {
        int numberOfZeros = 0;

        // Iterate through the array to find non-zero elements
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                // Count the number of zeros
                numberOfZeros++;
            } else {
                // Swap the current non-zero element to the correct position
                int temp = nums[i - numberOfZeros];
                nums[i - numberOfZeros] = nums[i];
                nums[i] = temp;
            }
        }
    }

}
