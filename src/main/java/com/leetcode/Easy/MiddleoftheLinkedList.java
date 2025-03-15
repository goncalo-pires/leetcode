package com.leetcode.Easy;

import com.leetcode.utils.ListNode;

public class MiddleoftheLinkedList {
    /**
     * Function to find the middle node of a singly linked list.
     * If the list has an even number of nodes, it returns the second middle node.
     *
     * Approach: This solution uses two pointers: 'slow' and 'fast'.
     * The 'slow' pointer moves one step at a time, while the 'fast' pointer moves two steps at a time.
     * When the 'fast' pointer reaches the end of the list, the 'slow' pointer will be at the middle.
     *
     * @param head the head of the linked list
     * @return the middle node of the linked list
     */
    public ListNode middleNode(ListNode head) {
        // Initialize two pointers: slow and fast
        ListNode slow = head;
        ListNode fast = head;

        // Move 'fast' two steps at a time and 'slow' one step at a time
        // When 'fast' reaches the end, 'slow' will be at the middle
        while (fast != null && fast.next != null) {
            fast = fast.next.next;  // Move fast pointer two steps
            slow = slow.next;       // Move slow pointer one step
        }

        // Return the slow pointer which is at the middle node
        return slow;
    }

    /**
     * Function to find the middle node of a singly linked list.
     * This solution counts the number of nodes in the list and then iterates to find the middle.
     *
     * @param head the head of the linked list
     * @return the middle node of the linked list
     */
    public ListNode middleNode2(ListNode head) {
        // Step 1: Count the number of nodes in the list
        int count = 0;
        ListNode current = head;
        while (current.next != null) {
            count++;
            current = current.next;
        }

        // Step 2: Find the middle node's position
        int mid = (count + 1) / 2;  // Middle index
        current = head;

        // Step 3: Traverse to the middle node
        while (mid > 0) {
            current = current.next;
            mid--;
        }

        // Return the current node, which is the middle node
        return current;
    }


}
