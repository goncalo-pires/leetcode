package com.leetcode.Easy;

public class FindTheIndexOfTheFirstOccurenceInAString {

    /**
     * Finds the index of the first occurrence of needle in haystack.
     *
     * @param haystack The main string where we search.
     * @param needle   The substring to find within haystack.
     * @return The index of the first occurrence of needle in haystack, or -1 if not found.
     */
    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

}
