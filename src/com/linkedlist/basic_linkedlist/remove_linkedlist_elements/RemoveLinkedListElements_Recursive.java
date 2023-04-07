package com.linkedlist.basic_linkedlist.remove_linkedlist_elements;

import com.common.datastructure.ListNode;

public class RemoveLinkedListElements_Recursive {
    public ListNode removeElements(ListNode head, int val) {
        // If the head is null, return null.
        if (head == null) return null;

        // Recursively call the removeElements function with the next node
        // as the new head.
        head.next = removeElements(head.next, val);

        // If the value of the head node equals the value to be removed,
        // return the next node as the new head, effectively removing the head node.
        // Otherwise, return the head node itself.
        return head.val == val ? head.next : head;
    }
}

