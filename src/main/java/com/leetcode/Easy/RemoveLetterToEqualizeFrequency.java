package com.leetcode.Easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RemoveLetterToEqualizeFrequency {


    /**
     * This method checks if it's possible to remove one letter from the word so that the frequency of every
     * letter in the word becomes equal.
     *
     * @param word The input string consisting of lowercase English letters.
     * @return true if it's possible to remove one letter to make all frequencies equal, false otherwise.
     */
    public boolean equalFrequency(String word) {

        // Step 1: Get the frequency count map where key is the frequency of characters and value is how many characters
        //         have that frequency.
        Map<Integer, Integer> result = getOccurrenceCountMap(word);

        // Print the occurrence count map for debugging purposes.
        System.out.println(result);

        // Get the size of the map (number of distinct frequencies).
        int resultSize = result.size();
        System.out.println(resultSize);

        // Extract the keys (frequencies) and values (number of characters having those frequencies).
        List<Integer> keysList = new ArrayList<>(result.keySet());
        List<Integer> valuesList = new ArrayList<>(result.values());

        // Case 1: If there are more than 2 distinct frequencies, return false because we can't equalize them with just one removal.
        if (resultSize > 2) return false;

        // Case 2: If there is only one distinct frequency
        if (resultSize == 1) {
            // If the only frequency is 1, we can remove any one character (it becomes an empty string, all frequencies are 0).
            // If all characters have the same frequency greater than 1, we can remove one to make all frequencies equal.
            if (keysList.get(0) == 1) return true;
            else if (valuesList.get(0) == 1) return true;
            return false;
        }
        // Case 3: If there are exactly two distinct frequencies
        else {
            int valueFirst = valuesList.get(0);  // The count of characters with the first frequency
            int valueSecond = valuesList.get(1); // The count of characters with the second frequency
            int keyFirst = keysList.get(0);      // The first frequency
            int keySecond = keysList.get(1);     // The second frequency

            // Check if we can make all frequencies equal by removing one letter:
            // - Case 1: One of the frequencies is 1 and there is exactly one character with that frequency (removable)
            // - Case 2: The difference between the two frequencies is 1, and the higher frequency has exactly one character
            return (keyFirst == 1 && valueFirst == 1) || (keySecond - keyFirst == 1 && valueSecond == 1);
        }
    }

    /**
     * This helper method counts the occurrences of each frequency in the input word.
     *
     * @param input The input string consisting of lowercase English letters.
     * @return A map where keys represent the frequency of characters, and values represent how many characters have that frequency.
     */
    public static Map<Integer, Integer> getOccurrenceCountMap(String input) {
        // Step 1: Count the frequency of each character
        Map<Character, Integer> charCountMap = new HashMap<>();
        for (char c : input.toCharArray()) {
            charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
        }

        // Step 2: Count how many characters have the same frequency
        Map<Integer, Integer> occurrenceCountMap = new HashMap<>();
        for (int count : charCountMap.values()) {
            occurrenceCountMap.put(count, occurrenceCountMap.getOrDefault(count, 0) + 1);
        }

        // Step 3: Return the occurrence count map
        return occurrenceCountMap;
    }
}
