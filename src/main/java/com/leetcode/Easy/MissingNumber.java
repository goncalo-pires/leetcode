package com.leetcode.Easy;

import java.util.Arrays;

public class MissingNumber {

    /**
     * Function to find the missing number in a range from 0 to n where n is the length of the array.
     * The function uses XOR to find the missing number efficiently in O(n) time and O(1) space.
     * XORing all numbers in the array with their indices and the array length gives the missing number.
     *
     * @param nums the input array containing n distinct numbers in the range [0, n]
     * @return the missing number from the array
     */
    public int missingNumber(int[] nums) {
        int aux = 0;

        // XOR all the indices and corresponding numbers in the array
        for (int i = 0; i < nums.length; i++) {
            aux ^= i ^ nums[i];
        }

        // XOR the result with the length of the array to get the missing number
        return aux ^ nums.length;
    }

    /**
     * Function to find the missing number by sorting the array first.
     * It then checks the difference between each number and its previous number to find the missing one.
     * This solution has a time complexity of O(n log n) due to sorting.
     *
     * @param nums the input array containing n distinct numbers in the range [0, n]
     * @return the missing number from the array
     */
    public int missingNumber2(int[] nums) {
        Arrays.sort(nums);  // Sort the array

        int prev = nums[0];

        // Iterate through the sorted array and check for the missing number
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != prev + 1) {
                return prev + 1;  // The missing number is the one between prev and nums[i]
            }
            prev = nums[i];
        }

        // If no missing number is found in the loop, check for the missing number at the ends
        return nums[0] == 0 ? nums.length : 0;  // If the array starts with 0, return nums.length, else return 0
    }

}
