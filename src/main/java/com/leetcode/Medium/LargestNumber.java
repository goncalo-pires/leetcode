package com.leetcode.Medium;

import java.util.Arrays;

public class LargestNumber {

    /**
     * Function to arrange a list of non-negative integers such that they form the largest possible number.
     * The numbers should be arranged in such a way that the concatenation of the numbers results in the largest number.
     * Since the result may be very large, the answer should be returned as a string.
     *
     * @param nums an array of non-negative integers
     * @return the largest number that can be formed by arranging the integers, represented as a string
     */
    public String largestNumber(int[] nums) {
        // Convert the integers to strings to facilitate comparison during sorting
        String[] arr = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = String.valueOf(nums[i]);
        }

        // Sort the array in descending order based on the concatenation of two strings (a + b) and (b + a)
        // If (a + b) > (b + a), a should appear before b
        Arrays.sort(arr, (a, b) -> (b + a).compareTo(a + b));

        // If the largest number is "0", return "0" to handle the case where all numbers are zero
        if (arr[0].equals("0")) {
            return "0";
        }

        // Use a StringBuilder to construct the largest number from the sorted strings
        StringBuilder sb = new StringBuilder();
        for (String s : arr) {
            sb.append(s);
        }

        return sb.toString();
    }

}
