package com.linkedlist.fast_and_slow_pointers.linkedlist_cycle;

import com.common.datastructure.ListNode;

public class LinkedListCycle {
    // We need to find if a cycle exists
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;

        // Perform a fast and slow pointer technique to find if a cycle exists in the list
        ListNode slow = head, fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            // Cycle exists as fast and slow pointer are equal
            if (slow == fast) return true;
        }

        return false;
    }
}
