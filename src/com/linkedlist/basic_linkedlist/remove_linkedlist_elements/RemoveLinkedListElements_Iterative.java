package com.linkedlist.basic_linkedlist.remove_linkedlist_elements;

import com.common.datastructure.ListNode;

public class RemoveLinkedListElements_Iterative {
    public ListNode removeElements(ListNode head, int val) {
        // Create a new temporary head node with a dummy value of -1
        ListNode tempHead = new ListNode(-1);

        // Set the next node of the dummy head to be the original head
        tempHead.next = head;

        // Create a node pointer to traverse the linked list
        ListNode node = tempHead;

        // Traverse the linked list until the end is reached
        while (node.next != null) {
            // If the next node has the value to be removed, skip over it
            if (node.next.val == val) {
                node.next = node.next.next;
            } else {
                // Otherwise, move the node pointer forward
                node = node.next;
            }
        }

        // Return the modified linked list (not including the dummy head)
        return tempHead.next;
    }
}

