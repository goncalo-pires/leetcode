package com.leetcode.Medium;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {

        int maxLength = 0, left = 0;
        Set<Character> seen = new HashSet<>();
        char[] arr = s.toCharArray();

        for (int right = 0; right < arr.length; right++) {

            while (seen.contains(arr[right])) {
                seen.remove(arr[left]);
                left++;
            }

            seen.add(arr[right]);
            maxLength = Math.max(maxLength, right - left + 1);

        }

        return maxLength;

    }

}
