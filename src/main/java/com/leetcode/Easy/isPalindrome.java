package com.leetcode.Easy;

public class isPalindrome {

    /**
     * Function to check if an integer is a palindrome.
     *
     * @param x the integer to check
     * @return true if the integer is a palindrome, otherwise false
     */
    public boolean isPalindrome(int x) {

        // If x is negative or ends with 0 (except when x is 0), it's not a palindrome
        if (x < 0 || (x % 10 == 0 && x != 0)) return false;

        int rev = 0;  // Variable to store the reversed half of the number

        // Reverse the second half of the number
        while (x > rev) {
            rev = rev * 10 + x % 10;  // Add the last digit of x to rev
            x = x / 10;               // Remove the last digit from x
        }

        // For even-length numbers, x will be equal to rev,
        // For odd-length numbers, rev/10 will be equal to x (because the middle digit doesn't matter)
        return x == rev || x == rev / 10;
    }

}
