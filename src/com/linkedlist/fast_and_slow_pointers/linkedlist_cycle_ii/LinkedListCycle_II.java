package com.linkedlist.fast_and_slow_pointers.linkedlist_cycle_ii;

import com.common.datastructure.ListNode;

public class LinkedListCycle_II {
    // If a cycle exists we need to find the start of the cycle
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null)
            return null;

        ListNode slow = head, fast = head;

        // Perform fast and slow pointer to detect if a cycle exists
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            // There is a cycle so break out of the loop
            if (slow == fast)
                break;
        }

        // If a cycle exists, find the start of the loop
        if (slow == fast) {
            slow = head;
            // Perform fast and slow pointer technique to find the start of the loop
            while (slow != fast) {
                slow = slow.next;
                fast = fast.next;
            }

            // Return the start of the loop
            return slow;
        }

        // No loop exists so return null
        return null;
    }
}
