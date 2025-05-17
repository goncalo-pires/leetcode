package com.leetcode.Medium;

import java.util.HashMap;

public class TwoSumIIInputArrayIsSorted {

    public int[] twoSum(int[] numbers, int target) {
        HashMap<Integer, Integer> reverted = new HashMap<>();

        for (int i=0; i<numbers.length; i++) {
            int curr = numbers[i];
            if (reverted.containsKey(curr)) {
                return new int[]{reverted.get(curr), i+1};
            }
            if (curr > target) {
                reverted.put(curr-target, i+1);
            }
            reverted.put(target-curr, i+1);
        }

        return new int[]{-1,-1};
    }

}
