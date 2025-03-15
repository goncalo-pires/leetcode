package com.leetcode.Easy;

import com.leetcode.utils.ListNode;

public class ReverseLinkedList {

    /**
     * Function to reverse the given singly linked list.
     *
     * @param head the head of the singly linked list
     * @return the head of the reversed linked list
     */
    public ListNode reverseList(ListNode head) {
        // Base case: if the list is empty or has only one node, it's already reversed
        if (head == null || head.next == null) {
            return head;
        }

        // Initialize pointers to reverse the list
        ListNode prev = null;
        ListNode current = head;
        ListNode next = null;

        // Traverse the list and reverse the pointers
        while (current != null) {
            // Save the next node
            next = current.next;

            // Reverse the current node's pointer
            current.next = prev;

            // Move prev and current one step forward
            prev = current;
            current = next;
        }

        // prev will be the new head of the reversed list
        return prev;
    }
}
