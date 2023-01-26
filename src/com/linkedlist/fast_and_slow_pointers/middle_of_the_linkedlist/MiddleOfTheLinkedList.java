package com.linkedlist.fast_and_slow_pointers.middle_of_the_linkedlist;

import com.common.datastructure.ListNode;

public class MiddleOfTheLinkedList {
    public ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;

        // Perform a fast and slow pointer technique to find the middle of the linked list
        // since fast pointer covers twice the nodes as slow pointer, so when fast is at the end
        // of the list, slow will be halfway through the list, i.e. the middle of the linked list
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}
