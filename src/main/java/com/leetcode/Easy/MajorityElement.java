package com.leetcode.Easy;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {

    /**
     * Finds the majority element in the given array.
     *
     * @param nums An integer array where the majority element always exists.
     * @return The majority element in the array.
     */
    public int majorityElement(int[] nums) {
        // HashMap to store frequency of elements
        Map<Integer, Integer> seen = new HashMap<>();
        int max = 0; // Track the maximum count found
        int res = 0; // Store the majority element

        // Iterate through each element in the array
        for (int n : nums) {
            // Get current count and update it
            int val = seen.getOrDefault(n, 0) + 1;
            seen.put(n, val);

            // Update majority element if a higher frequency is found
            if (val > max) {
                max = val;
                res = n;
            }
        }
        return res;
    }

}
