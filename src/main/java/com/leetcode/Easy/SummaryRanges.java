package com.leetcode.Easy;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {

    /**
     * Function to return the smallest sorted list of ranges that cover all the numbers in the sorted array.
     * Each range [a,b] is represented as "a->b" if a != b, and "a" if a == b.
     *
     * @param nums the sorted unique integer array
     * @return a list of strings representing the ranges that cover all numbers in the array
     */
    public List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>();

        // Return an empty list if the input array is empty
        if (nums.length == 0) return list;

        int first = nums[0];  // Initialize first element of the range
        int last = nums[0];   // Initialize last element of the range

        // Iterate through the array to identify the ranges
        for (int i = 1; i < nums.length; i++) {
            // If the current number is consecutive to the last number, extend the range
            if (nums[i] - 1 == last) {
                last = nums[i];
            } else {
                // If the range is not continuous, add the current range to the list
                String s = String.valueOf(first);
                if (first != last) {
                    s += "->" + String.valueOf(last); // Include range notation if start and end are different
                }
                list.add(s);

                // Start a new range
                first = nums[i];
                last = nums[i];
            }
        }

        // Add the final range to the list
        String s = String.valueOf(first);
        if (first != last) {
            s += "->" + String.valueOf(last); // Include range notation if start and end are different
        }
        list.add(s);

        return list;
    }

}
