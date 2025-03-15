package com.leetcode.Easy;

public class RunningSumof1dArray {

    /**
     * Function to calculate the running sum of an array.
     * The running sum at index i is defined as the sum of elements from index 0 to i.
     *
     * @param nums an integer array for which we need to compute the running sum.
     * @return an integer array representing the running sum.
     */
    public int[] runningSum(int[] nums) {
        // Start from index 1 and update the current element with the sum of the previous element and itself.
        for (int i = 1; i < nums.length; i++) {
            // Update nums[i] by adding the value of nums[i-1] to nums[i]
            nums[i] = nums[i - 1] + nums[i];
        }
        // Return the updated array containing the running sum
        return nums;
    }

}
