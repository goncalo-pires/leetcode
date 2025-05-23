package com.leetcode.Medium;

public class ReverseLinkedListII {

    public ListNode reverseBetween(ListNode head, int left, int right) {

        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode prev = dummy;

        for (int i=0; i<left-1; i++) {
            prev = prev.next;
        }

        ListNode curr = prev.next;

        for (int i=0; i<right-left; i++) {
            ListNode after = curr.next;
            curr.next = after.next;
            after.next = prev.next;
            prev.next = after;
        }

        return dummy.next;
    }

}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

