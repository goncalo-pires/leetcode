package com.leetcode.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);

        for (int i=0; i<nums.length-2; i++) {
            if (i > 0 && nums[i] == nums[i-1]) continue;
            int first = nums[i];
            int leftIndex = i+1;
            int rightIndex = nums.length-1;

            while (leftIndex < rightIndex) {
                int second = nums[leftIndex];
                int third = nums[rightIndex];
                int res = first + second + third;

                if (res == 0) {
                    list.add(List.of(first, second, third));
                    leftIndex++;
                    while (nums[leftIndex] == nums[leftIndex-1] && leftIndex < rightIndex) {
                        leftIndex++;
                    }
                } else if (res < 0) {
                    leftIndex++;
                } else {
                    rightIndex--;
                }
            }

        }


        return list;
    }

}
