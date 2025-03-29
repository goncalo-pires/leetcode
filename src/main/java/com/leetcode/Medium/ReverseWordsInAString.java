package com.leetcode.Medium;

public class ReverseWordsInAString {

    /**
     * Reverses the order of words in the given string.
     *
     * @param s The input string containing words separated by spaces.
     * @return A string with words in reverse order, separated by a single space.
     */
    public String reverseWords(String s) {
        // Split the input string by spaces
        String[] split = s.split(" ");
        StringBuilder sb = new StringBuilder();

        // Iterate through the words in reverse order
        for (int i = split.length - 1; i >= 0; i--) {
            // Ignore empty strings resulting from multiple spaces
            if (!split[i].trim().isEmpty()) {
                sb.append(split[i]).append(" ");
            }
        }

        // Convert StringBuilder to String and remove trailing spaces
        return sb.toString().trim();
    }

}
