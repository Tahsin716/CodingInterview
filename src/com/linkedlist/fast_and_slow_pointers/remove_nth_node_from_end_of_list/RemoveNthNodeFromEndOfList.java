package com.linkedlist.fast_and_slow_pointers.remove_nth_node_from_end_of_list;

import com.common.datastructure.ListNode;

public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Initialize a ListNode(0) tempHead, and assign tempHead.next = head.
        // This is to handle cases like head[1], n = 1.
        //
        // Also, since we are using fast & slow pointer.
        // This is make sure the slow pointer is one node before the nth node,
        // so that we can remove it, by slow.next = slow.next.next.
        ListNode tempHead = new ListNode(0);
        ListNode slow = tempHead, fast = tempHead;
        tempHead.next = head;

        // Iterate from 0...n(inclusive) and traverse fast = fast.next.
        // This is to create a gap between slow and fast by n steps.
        // So that when fast == null, slow will be at (n+1)th node from the end.
        for (int i = 0; i <= n; i++) fast = fast.next;

        // While fast != null, traverse slow = slow.next and fast = fast.next.
        // Slow is at the node before the nth node from the end
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        // Slow is the node before the nth node, so assign slow.next = slow.next.next
        // to remove the nth node from the end of the list
        slow.next = slow.next.next;

        return tempHead.next;
    }
}
