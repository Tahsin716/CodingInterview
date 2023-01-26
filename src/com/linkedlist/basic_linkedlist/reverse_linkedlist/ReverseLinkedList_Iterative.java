package com.linkedlist.basic_linkedlist.reverse_linkedlist;

import com.common.datastructure.ListNode;

public class ReverseLinkedList_Iterative {
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;

        // Assign node and tempNode to head
        // We will reverse the list using tempNode
        // previousNode will be the head of the linked list after reversing it
        ListNode node = head;
        ListNode temp = head;
        ListNode previousNode = null;

        while (node != null) {
            // Shift node forward to next node
            node = node.next;
            // Reverse list by assigning tempNode.next to previousNode
            temp.next = previousNode;
            // previousNode will now be = temp, the current node
            previousNode = temp;
            // we then move temp = next node
            temp = node;
        }

        return previousNode;
    }
}
