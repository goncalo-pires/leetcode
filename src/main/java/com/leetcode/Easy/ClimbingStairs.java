package com.leetcode.Easy;

public class ClimbingStairs {

    /**
     * Function to calculate the number of distinct ways to climb to the top of a staircase
     * with n steps, where at each step you can climb either 1 or 2 steps.
     *
     * @param n the number of steps to reach the top
     * @return the number of distinct ways to climb to the top
     */
    public int climbStairs(int n) {
        // Base cases: if there are 1 or 2 steps, there are as many ways to climb as there are steps
        if (n <= 3) return n;

        // Initialize the first two values of the sequence
        int prev = 1;  // Number of ways to reach the 1st step
        int curr = 2;  // Number of ways to reach the 2nd step

        // Loop from the 3rd step to the nth step to calculate the number of ways
        for (int i = 3; i <= n; i++) {
            int temp = curr;  // Save the current value (number of ways to reach the current step)
            curr += prev;  // Update current number of ways by summing up the ways to reach the previous and the step before that
            prev = temp;  // Move the current value to the previous step's value
        }

        // Return the total number of ways to reach the nth step
        return curr;
    }

}
