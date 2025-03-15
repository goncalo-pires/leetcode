package com.leetcode.Easy;

import java.util.Arrays;

public class MaximumProductofThreeNumbers {

    /**
     * Function to find three numbers in the array whose product is maximum.
     *
     * Given an integer array nums, we need to find three numbers whose product
     * is the maximum possible product. The product can either come from the
     * three largest numbers or two smallest (negative) numbers and the largest
     * positive number.
     *
     * @param nums the array of integers
     * @return the maximum product of three numbers
     */
    public int maximumProduct(int[] nums) {
        int len = nums.length;

        // If the array contains only one number, return that number
        if (len == 1) return nums[0];

        // If the array contains two numbers, return their product
        if (len == 2) return nums[0] * nums[1];

        // Sort the array to easily access the largest and smallest elements
        Arrays.sort(nums);

        // The maximum product can either be the product of the three largest
        // numbers or the product of the two smallest (negative) numbers and the
        // largest number.
        return Math.max(nums[len-1] * nums[len-2] * nums[len-3],
                nums[0] * nums[1] * nums[len-1]);
    }

}
