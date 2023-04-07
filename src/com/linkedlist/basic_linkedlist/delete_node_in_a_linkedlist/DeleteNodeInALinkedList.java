package com.linkedlist.basic_linkedlist.delete_node_in_a_linkedlist;

import com.common.datastructure.ListNode;

public class DeleteNodeInALinkedList {
    public void deleteNode(ListNode node) {
        // This is basically updating the node's value to the next node
        // and assigning node's next to node.next.next
        node.val = node.next.val;
        node.next = node.next.next;
    }
}