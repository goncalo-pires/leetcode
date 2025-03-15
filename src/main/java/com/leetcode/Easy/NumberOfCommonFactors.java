package com.leetcode.Easy;

public class NumberOfCommonFactors {

    /**
     * This function returns the number of common factors between two positive integers a and b.
     * A common factor is a number that divides both a and b without leaving any remainder.
     *
     * @param a The first positive integer
     * @param b The second positive integer
     * @return The number of common factors between a and b
     */
    public int commonFactors(int a, int b) {
        // Find the minimum of a and b, as the number of common factors cannot exceed the smaller number
        int n = Math.min(a, b);

        // Variable to keep track of the number of common factors
        int number = 0;

        // Loop through all integers from 1 to the smaller of the two numbers (n)
        for (int i = 1; i <= n; i++) {
            // Check if i divides both a and b
            if (a % i == 0 && b % i == 0) {
                number++;  // Increment the count of common factors
            }
        }

        // Return the total number of common factors
        return number;
    }

}
