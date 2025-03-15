package com.leetcode.Easy;

import java.util.HashSet;

public class ContainsDuplicate {

    /**
     * Function to determine if any value appears at least twice in the array.
     *
     * @param nums the array of integers
     * @return true if any value appears at least twice, false if all elements are distinct
     */
    public boolean containsDuplicate(int[] nums) {
        // Initialize a HashSet to track seen numbers
        HashSet<Integer> seen = new HashSet<>();

        // Iterate through the array
        for (int num : nums) {
            // If the number is already in the set, return true as it's a duplicate
            if (seen.contains(num)) {
                return true;
            } else {
                // Add the number to the set
                seen.add(num);
            }
        }

        // If no duplicates are found, return false
        return false;
    }

}
