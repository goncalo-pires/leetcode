package com.leetcode.Medium;

import com.leetcode.utils.ListNode;

import java.util.ArrayList;
import java.util.Stack;

public class NextGreaterNodeInLinkedList {
    /**
     * Function to find the value of the next greater node for each node in the linked list.
     * For each node, find the first node that is next to it and has a strictly larger value than it.
     * If no such node exists, set the value to 0 for that node.
     *
     * Approach: We first convert the linked list to an array for easier manipulation.
     * Then, we use a stack to keep track of the indices of nodes while processing them.
     * The stack helps us to efficiently find the next greater node for each node in the list.
     *
     * @param head the head node of the linked list
     * @return an array of integers where each element represents the next greater node for each node
     */
    public int[] nextLargerNodes(ListNode head) {
        // Initialize an ArrayList to store the values of the linked list nodes
        ArrayList<Integer> list = new ArrayList<>();
        ListNode current = head;

        // Traverse the linked list and add all node values to the list
        while (current != null) {
            list.add(current.val);
            current = current.next;
        }

        // Initialize an array to store the next greater value for each node
        int[] ans = new int[list.size()];

        // Stack to keep track of indices of nodes for which we are trying to find the next greater value
        Stack<Integer> st = new Stack<>();

        // Traverse the list to calculate the next greater node for each node
        for (int i = 0; i < list.size(); i++) {
            // While the stack is not empty and the current node's value is greater than the value at the index
            // of the top of the stack, we update the result for that index.
            while (!st.isEmpty() && list.get(i) > list.get(st.peek())) {
                // Pop the index and set the next greater value for that node
                ans[st.pop()] = list.get(i);
            }

            // Push the current index onto the stack
            st.push(i);
        }

        // The remaining indices in the stack represent nodes with no next greater node, so they remain 0.
        return ans;
    }


}
