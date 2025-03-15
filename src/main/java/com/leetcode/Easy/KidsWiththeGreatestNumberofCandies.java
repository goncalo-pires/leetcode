package com.leetcode.Easy;

import java.util.ArrayList;
import java.util.List;

public class KidsWiththeGreatestNumberofCandies {

    /**
     * Function to determine if each kid can have the greatest number of candies after
     * adding extraCandies to their current count.
     *
     * @param candies an integer array representing the number of candies each kid has.
     * @param extraCandies the number of extra candies you can distribute.
     * @return a list of booleans where each boolean indicates if the ith kid will have
     *         the greatest number of candies after receiving the extraCandies.
     */
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        // Initialize a variable to keep track of the maximum candies any kid has
        int max = 0;
        // Find the maximum number of candies among all kids
        for (int n : candies) {
            max = Math.max(n, max);  // Update max if a kid has more candies than the current max
        }

        // Create a list to store the result for each kid
        List<Boolean> result = new ArrayList<>();
        // Iterate through the candies array and check if the ith kid will have the greatest number of candies
        for (int candy : candies) {
            // If the current kid's candies plus extraCandies is greater than or equal to max, they will have the greatest number of candies
            boolean hasMore = candy + extraCandies >= max;
            result.add(hasMore);  // Add the result to the list
        }

        // Return the result list
        return result;
    }

}
