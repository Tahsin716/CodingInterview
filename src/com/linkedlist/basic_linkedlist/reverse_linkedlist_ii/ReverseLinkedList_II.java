package com.linkedlist.basic_linkedlist.reverse_linkedlist_ii;

import com.common.datastructure.ListNode;

public class ReverseLinkedList_II {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null) return null;

        ListNode tempHead = new ListNode(-1);
        ListNode prev = tempHead;
        tempHead.next = head;

        // Find the node right before the left node
        for (int i = 0; i < left - 1; i++) {
            prev = prev.next;
        }

        // Assign current = prev.next (the left node)
        // we will use next node to reverse the linked list
        ListNode current = prev.next, next = current.next;

        // iterate from i := 0 -> i < right - left to reverse the sublist
        for (int i = 0; i < right - left; i++) {
            // Use pen and paper to get the visual representation of how
            // the swapping is done to reverse the list, this part is quite tricky
            // this similar method is used for the problem: Reverse Nodes in K groups
            current.next = next.next;
            next.next = prev.next;
            prev.next = next;
            next = current.next;
        }

        return tempHead.next;
    }
}
