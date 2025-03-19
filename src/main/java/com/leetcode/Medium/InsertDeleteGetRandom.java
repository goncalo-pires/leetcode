package com.leetcode.Medium;

import java.util.*;

/**
 * RandomizedSet class that supports O(1) average time complexity for insert, remove, and getRandom operations.
 */
public class InsertDeleteGetRandom {

    private final Map<Integer, Integer> map; // Stores value -> index mapping
    private final List<Integer> list; // Stores the values for O(1) random access
    private final Random random; // Random number generator

    /**
     * Initializes the InsertDeleteGetRandom object.
     */
    public InsertDeleteGetRandom() {
        map = new HashMap<>(); // HashMap for quick lookup
        list = new ArrayList<>(); // ArrayList for fast random access
        random = new Random(); // Random instance
    }

    /**
     * Inserts an item val into the set if not already present.
     * @param val The value to insert.
     * @return true if the item was not present, false otherwise.
     */
    public boolean insert(int val) {
        if (map.containsKey(val)) return false; // Return false if already present

        map.put(val, list.size()); // Store index of val in map
        list.add(val); // Add val to list

        return true;
    }

    /**
     * Removes an item val from the set if present.
     * @param val The value to remove.
     * @return true if the item was present, false otherwise.
     */
    public boolean remove(int val) {
        if (!map.containsKey(val)) return false; // Return false if not found

        int index = map.get(val); // Get index of val
        int lastValue = list.getLast(); // Get last element in the list

        // Swap val with lastValue
        list.set(index, lastValue);
        map.put(lastValue, index); // Update lastValue's new index in map

        // Remove last element (which was val)
        list.removeLast();
        map.remove(val);

        return true;
    }

    /**
     * Returns a random element from the set.
     * @return A randomly selected element from the set.
     */
    public int getRandom() {
        return list.get(random.nextInt(list.size())); // Get random index and return value
    }
}
