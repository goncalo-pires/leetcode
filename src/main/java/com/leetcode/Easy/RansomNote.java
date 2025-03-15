package com.leetcode.Easy;

public class RansomNote {

    /**
     * Function to determine if a ransom note can be constructed from a magazine string.
     *
     * The function uses an array to count the frequency of each character in the magazine string.
     * It then iterates through each character in the ransom note, checking if there are enough characters
     * in the magazine to form the ransom note. If any character is not available or is used more times
     * than it appears in the magazine, the function returns false. Otherwise, it returns true.
     *
     * @param ransomNote the string representing the ransom note
     * @param magazine the string representing the magazine
     * @return true if the ransom note can be constructed from the magazine, false otherwise
     */
    public boolean canConstruct(String ransomNote, String magazine) {
        // Create an array to count the occurrences of each character in the magazine
        int[] count = new int[26];

        // Count the frequency of each character in the magazine
        for (char c : magazine.toCharArray()) {
            count[c - 'a']++;
        }

        // Check if the ransom note can be constructed by using characters from the magazine
        for (char c : ransomNote.toCharArray()) {
            // If there's no more of the current character in the magazine, return false
            if (count[c - 'a'] == 0) return false;
            // Decrease the count of the current character
            count[c - 'a']--;
        }

        // Return true if the ransom note can be constructed
        return true;
    }

}
