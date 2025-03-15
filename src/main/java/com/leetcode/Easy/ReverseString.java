package com.leetcode.Easy;

public class ReverseString {

    /**
     * Function to reverse a string in place given as an array of characters.
     *
     * The function iterates through the first half of the array, swapping each character with
     * the corresponding character from the second half of the array. This is done in-place,
     * meaning that the input array is directly modified with no extra space used for storing the result.
     *
     * @param s the array of characters representing the input string
     */
    public void reverseString(char[] s) {
        // Iterate through the first half of the array
        for (int i = 0; i < s.length / 2; i++) {
            // Swap the characters at positions i and s.length - 1 - i
            char temp = s[i];
            s[i] = s[s.length - 1 - i];
            s[s.length - 1 - i] = temp;
        }
    }

}
