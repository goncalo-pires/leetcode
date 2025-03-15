package com.leetcode.Easy;

import java.util.HashSet;

public class CheckiftheSentenceIsPangram {

    /**
     * Check if a given sentence is a pangram.
     * A pangram is a sentence where every letter of the English alphabet appears at least once.
     *
     * @param sentence The input string consisting of lowercase English letters.
     * @return true if the sentence is a pangram, otherwise false.
     */
    public boolean checkIfPangram(String sentence) {
        // Create a HashSet to store unique characters
        HashSet<Character> set = new HashSet<>();

        // Iterate over each character in the sentence and add it to the set
        for (char c : sentence.toCharArray()) {
            set.add(c);  // Add each character to the set
        }

        // Check if the set contains all 26 letters of the alphabet
        return set.size() == 26;  // If the set contains 26 unique letters, it's a pangram
    }

}
