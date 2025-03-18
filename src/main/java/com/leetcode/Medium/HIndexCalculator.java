package com.leetcode.Medium;

import java.util.Arrays;

public class HIndexCalculator {

    /**
     * Computes the h-index of a researcher.
     *
     * @param citations An integer array where citations[i] represents the number of citations for the ith paper.
     * @return The researcher's h-index.
     */
    public static int hIndex(int[] citations) {
        // Step 1: Sort the citations array in ascending order
        Arrays.sort(citations);
        int n = citations.length;

        // Step 2: Iterate over the sorted array to determine the h-index
        for (int i = 0; i < n; i++) {
            int h = n - i; // Number of papers with at least citations[i] citations
            if (citations[i] >= h) {
                return h; // The first valid h-index found
            }
        }
        return 0; // If no valid h-index is found, return 0
    }
}
