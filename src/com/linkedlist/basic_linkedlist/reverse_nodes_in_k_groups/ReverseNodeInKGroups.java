package com.linkedlist.basic_linkedlist.reverse_nodes_in_k_groups;

import com.common.datastructure.ListNode;

public class ReverseNodeInKGroups {
    public ListNode reverseKGroup(ListNode head, int k) {
        // Reversing in groups of 1 will give the same list
        if (head == null || k == 1) return head;

        // Find the length of the list
        int length = lengthOfList(head);

        ListNode tempHead = new ListNode(-1);
        tempHead.next = head;

        ListNode current = tempHead, prev = tempHead, next = tempHead;

        // We will reverse the linked list as long as length >= k
        // i.e. we can form a sublist of length k
        while (length >= k) {
            // This step of reversing the linked list is exactly same as the problem: Reverse LinkedList II
            current = prev.next;
            next = current.next;

            // Iterate from i := 1 -> i < k to reverse this sublist
            for (int i = 1; i < k; i++) {
                current.next = next.next;
                next.next = prev.next;
                prev.next = next;
                next = current.next;
            }

            // Assign prev = current, as we need to reverse the next sublist
            // which is starts from current.next
            prev = current;
            // Decrement length by k, as we reversed a sublist of size k
            length -= k;
        }

        return tempHead.next;
    }

    private int lengthOfList(ListNode head) {
        int len = 0;

        ListNode node = head;

        while (node != null) {
            node = node.next;
            len++;
        }

        return len;
    }
}
