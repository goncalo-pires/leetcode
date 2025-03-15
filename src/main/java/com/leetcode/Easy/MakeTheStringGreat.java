package com.leetcode.Easy;

public class MakeTheStringGreat {

    /**
     * Removes all adjacent bad character pairs in the string.
     * A "bad" pair is when a lowercase letter and its uppercase version (or vice versa) appear adjacent in the string.
     * The method continues to remove such pairs until no bad pairs remain in the string.
     *
     * @param s The input string consisting of both lowercase and uppercase English letters.
     * @return A new string with all adjacent bad character pairs removed.
     */
    public String makeGood(String s) {
        // Convert the string into a character array to easily manipulate it.
        char[] res = s.toCharArray();

        // 'index' is used to track the position in the result array.
        int index = -1;

        // Iterate over each character in the input string.
        for (char c : res) {
            // Check if the current character 'c' and the previous character at 'index' form a bad pair.
            // A bad pair exists if the characters are the same letter but one is uppercase and the other is lowercase.
            if (index > -1 && (s.charAt(index) ^ c) == 32) {
                // If a bad pair is found, pop the previous character from the stack (decrease the index).
                index--;
            } else {
                // If no bad pair is found, push the current character onto the result (increment index).
                index++;
                res[index] = c;
            }
        }

        // Convert the character array back to a string, from position 0 to index + 1.
        return new String(res, 0, index + 1);
    }
}
