package com.leetcode.Medium;

public class JumpGame {

    /**
     * Determines if it is possible to reach the last index of the array.
     *
     * @param nums an integer array where each element represents the maximum jump length
     * @return true if the last index is reachable, otherwise false
     */
    public boolean canJump(int[] nums) {
        int goal = nums.length - 1; // Target index to reach

        // Traverse the array from second last index to the beginning
        for (int i = nums.length - 2; i >= 0; i--) {
            // If the current position can reach or surpass the goal, update the goal
            if (nums[i] + i >= goal) {
                goal = i;
            }
        }

        // If we are able to move the goal to the start index, return true
        return goal == 0;
    }
}
