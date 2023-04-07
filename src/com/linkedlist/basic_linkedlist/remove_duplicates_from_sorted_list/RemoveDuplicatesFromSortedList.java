package com.linkedlist.basic_linkedlist.remove_duplicates_from_sorted_list;

import com.common.datastructure.ListNode;

public class RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode node = head;

        // Iterate linked list while current node and next node is not null
        while (node != null && node.next != null) {
            // If current node's value is same as next node's value
            if (node.val == node.next.val) {
                // remove next node by assigning current node's next to next node's next
                node.next = node.next.next;
            } else {
                // current node's value is not equal to next node's value, so assign current node's next
                // to next node
                node = node.next;
            }
        }
        return head;
    }
}
