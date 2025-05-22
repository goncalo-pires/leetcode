package com.leetcode.Easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class IsomorphicStrings {

    public boolean isIsomorphic(String s, String t) {

        int size = s.length();

        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();

        Map<Character, Character> map = new HashMap<>();
        Set<Character> set = new HashSet<>();

        for (int i=0; i<size; i++) {

            char left = sArr[i];
            char right = tArr[i];

            if (map.containsKey(left)) {
                if (map.get(left) != right) {
                    return false;
                }
            } else if (set.contains(right)) {
                return false;
            }

            map.put(left, right);
            set.add(right);

        }

        return true;
    }

}
