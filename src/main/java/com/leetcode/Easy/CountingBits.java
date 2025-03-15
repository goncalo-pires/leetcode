package com.leetcode.Easy;

public class CountingBits {

    /**
     * Function to return an array where each element at index i represents the number of 1's
     * in the binary representation of i for all i from 0 to n.
     *
     * The function uses dynamic programming to calculate the number of 1's for each number
     * by using the previously computed results for smaller numbers. It utilizes the property
     * that the number of 1's in the binary representation of i is the same as the number of 1's
     * in i / 2 plus 1 if i is odd (i % 2 == 1).
     *
     * @param n the integer value up to which we need to count the number of 1's in binary representations
     * @return an array where each index contains the count of 1's in the binary representation of the index value
     */
    public int[] countBits(int n) {
        int[] arr = new int[n + 1];

        // Calculate the number of 1's for each number from 1 to n
        for (int i = 1; i <= n; i++) {
            arr[i] = arr[i / 2] + i % 2;  // arr[i/2] holds the number of 1's in the integer i / 2, and i % 2 adds 1 if i is odd
        }

        return arr;
    }

}
