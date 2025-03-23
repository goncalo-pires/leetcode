package com.leetcode.Easy;

public class LengthOfLastWord {

    /**
     * Returns the length of the last word in the string.
     * A word is defined as a maximal substring consisting of non-space characters only.
     *
     * @param s The input string consisting of words and spaces.
     * @return The length of the last word in the string.
     */
    public int lengthOfLastWord(String s) {
        String[] words = s.split(" ");
        String lastWord = words[words.length - 1];
        return lastWord.length();
    }
}
