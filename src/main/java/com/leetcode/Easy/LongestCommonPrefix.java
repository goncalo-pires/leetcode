package com.leetcode.Easy;

public class LongestCommonPrefix {

    /**
     * Function to find the longest common prefix among a given array of strings.
     *
     * @param strs the array of strings
     * @return the longest common prefix, or an empty string if there is no common prefix
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }

        // Start with the first string as the prefix
        String prefix = strs[0];

        // Iterate through the remaining strings
        for (int i = 1; i < strs.length; i++) {
            // While the current string does not start with the current prefix, shorten the prefix
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);

                // If the prefix is empty, return an empty string (no common prefix)
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }

        // Return the longest common prefix found
        return prefix;
    }
}
