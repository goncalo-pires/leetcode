package com.leetcode.Easy;

public class IsSubsequence {

    public boolean isSubsequence(String s, String t) {

        if (s.isEmpty()) return true;
        if (t.isEmpty()) return false;

        char[] arr = s.toCharArray();
        int index = 0;
        int end = s.length();

        for (char c : t.toCharArray()) {
            if (arr[index] == c) index++;
            if (index == end) return true;
        }

        return false;
    }
}
