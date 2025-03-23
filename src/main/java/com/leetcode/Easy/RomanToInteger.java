package com.leetcode.Easy;

public class RomanToInteger {

    /**
     * Converts a Roman numeral string to an integer.
     *
     * Roman numerals are represented by seven different symbols:
     * I, V, X, L, C, D, and M with values:
     * I = 1, V = 5, X = 10, L = 50, C = 100, D = 500, M = 1000.
     *
     * Subtractive notation is used for:
     * - I before V and X (4, 9)
     * - X before L and C (40, 90)
     * - C before D and M (400, 900)
     *
     * @param s The Roman numeral string (e.g., "XII", "IX", "MCMXCIV").
     * @return The corresponding integer value.
     */
    public int romanToInt(String s) {
        char[] arr = s.toCharArray(); // Convert string to character array
        int n = 0; // Stores the final integer value
        int last = 0; // Tracks the last numeral's value for subtraction logic

        // Iterate over the Roman numeral string from right to left
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = arr[i];

            // Map Roman numeral characters to their integer values
            int num = switch (c) {
                case 'I' -> 1;
                case 'V' -> 5;
                case 'X' -> 10;
                case 'L' -> 50;
                case 'C' -> 100;
                case 'D' -> 500;
                case 'M' -> 1000;
                default -> 0; // Handle invalid characters gracefully
            };

            // Apply subtraction rule if needed
            n = num < last ? n - num : n + num;
            last = num; // Update last seen value
        }
        return n; // Return the converted integer
    }
}
