package com.leetcode.Medium;

public class IntegerToRoman {

    // Method to convert an integer to a Roman numeral
    // @param num: The integer number to convert to Roman numeral
    // @return: A string representing the Roman numeral equivalent of the input number
    public String intToRoman(int num) {
        // Array of integer values in descending order to represent Roman numerals
        int[] n = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

        // Array of Roman numerals corresponding to the values in the above array
        String[] s = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        // StringBuilder to store the result (Roman numeral)
        StringBuilder res = new StringBuilder();

        // Loop through each value in the Roman numerals array
        for (int i = 0; i < n.length; i++) {
            // While the number is greater than or equal to the current value in the array
            while (num >= n[i]) {
                num -= n[i];  // Subtract the value from num
                res.append(s[i]);  // Append the Roman numeral corresponding to the value
            }
        }

        // Return the final Roman numeral as a string
        return res.toString();
    }
}
