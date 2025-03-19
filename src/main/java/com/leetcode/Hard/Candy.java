package com.leetcode.Hard;

import java.util.Arrays;

public class Candy {
    /**
     * Determines the minimum number of candies needed to distribute to children.
     *
     * @param ratings an integer array representing the rating values of children.
     * @return the minimum number of candies required.
     */
    public int candy(int[] ratings) {
        int[] candies = new int[ratings.length];
        Arrays.fill(candies, 1); // Each child gets at least one candy initially.

        // Forward pass: Ensure right neighbor gets more candy if they have a higher rating.
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                if (candies[i] <= candies[i - 1]) {
                    candies[i] = candies[i - 1] + 1;
                }
            }
        }

        // Backward pass: Ensure left neighbor gets more candy if they have a higher rating.
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                if (candies[i] <= candies[i + 1]) {
                    candies[i] = candies[i + 1] + 1;
                }
            }
        }

        // Calculate the total number of candies required.
        int count = 0;
        for (int candy : candies) {
            count += candy;
        }

        return count;
    }
}
