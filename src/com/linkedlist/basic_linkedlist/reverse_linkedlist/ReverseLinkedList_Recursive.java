package com.linkedlist.basic_linkedlist.reverse_linkedlist;

import com.common.datastructure.ListNode;

public class ReverseLinkedList_Recursive {
    public ListNode reverseList(ListNode head) {
        return reverseListRecursive(head, null);
    }

    private ListNode reverseListRecursive(ListNode node, ListNode previousNode) {
        // The current node is null, so we have reached the end of the linked list
        // so just return the previousNode
        if (node == null) {
            return previousNode;
        }

        // We will use tempNode to reverse the list
        ListNode temp = node;
        // Shift node forward to next node
        node = node.next;
        // Reverse the tempNode
        temp.next = previousNode;

        // tempNode is now the previousNode
        return reverseListRecursive(node, temp);
    }
}
