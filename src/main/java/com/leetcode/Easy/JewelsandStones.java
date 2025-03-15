package com.leetcode.Easy;

public class JewelsandStones {

    /**
     * Function to count the number of stones that are jewels.
     *
     * Given two strings:
     * - jewels: represents the types of stones that are jewels.
     * - stones: represents the stones you have.
     *
     * The function counts how many stones from the 'stones' string are also in the 'jewels' string.
     *
     * Each character in 'stones' is a type of stone, and the function checks if that stone is a jewel.
     *
     * @param jewels a string containing the types of jewels (characters)
     * @param stones a string containing the stones you have (characters)
     * @return the number of stones that are jewels
     */
    public int numJewelsInStones(String jewels, String stones) {
        // Initialize a variable to keep track of the number of jewels in the stones
        int count = 0;

        // Iterate through each stone in the 'stones' string
        for (char c : stones.toCharArray()) {
            // Check if the current stone is a jewel (i.e., it is present in 'jewels')
            if (jewels.indexOf(c) > -1) {
                // Increment the count if the stone is a jewel
                count++;
            }
        }

        // Return the total count of jewels found in stones
        return count;
    }

}
