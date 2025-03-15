package com.leetcode.Medium;

import com.leetcode.utils.ListNode;

import java.util.HashSet;
import java.util.Set;

public class LinkedListComponents {

    /**
     * Function to count the number of connected components in a linked list,
     * where each component consists of consecutive values in the linked list
     * that are present in the given integer array 'nums'.
     *
     * @param head the head of the linked list.
     * @param nums the array containing a subset of values in the linked list.
     * @return the number of connected components in 'nums' within the linked list.
     */
    public int numComponents(ListNode head, int[] nums) {
        // If the linked list is empty, there are no components
        if (head == null) return 0;

        // Create a set for fast lookup of elements in the 'nums' array
        Set<Integer> set = new HashSet<>();

        // Add each number from 'nums' to the set
        for (int num : nums) {
            set.add(num);
        }

        // Initialize count of connected components
        int count = 0;

        // Initialize a dummy 'before' node to compare consecutive elements
        ListNode before = new ListNode(-1);

        // Start with the head of the linked list
        ListNode current = head;

        // Traverse the linked list
        while (current != null) {
            // Check if the current node's value is in the 'nums' set
            boolean currentExists = set.contains(current.val);

            // Check if the previous node's value is in the 'nums' set
            boolean beforeExists = set.contains(before.val);

            // If current node is in 'nums' and the previous node is not in 'nums', we have a new component
            if (currentExists && !beforeExists) {
                count++;
            }

            // Move the 'before' pointer to the current node
            before = current;

            // Move the 'current' pointer to the next node in the linked list
            current = current.next;
        }

        // Return the count of connected components
        return count;
    }

}
