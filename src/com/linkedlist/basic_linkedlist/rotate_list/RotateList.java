package com.linkedlist.basic_linkedlist.rotate_list;

import com.common.datastructure.ListNode;

public class RotateList {
    // If k >= len, multiples of len will give the original result
    // so if len = 5, k = 5, 10, 15, 20... will give the original list, if rotated
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return null;

        ListNode tempHead = new ListNode(-1);
        tempHead.next = head;

        ListNode fast = tempHead, slow = tempHead;
        int length = 0;

        // Iterate to find the length of the list
        while (fast.next != null) {
            fast = fast.next;
            length++;
        }

        // Assign lastNode.next = head, to make a circular linked list
        fast.next = tempHead.next;

        // Find the length - k % length node, this will be the last node,
        // while its next node will be the head
        for (int i = 0; i < length - (k % length); i++) {
            slow = slow.next;
        }

        // (length - k % length)'th nodes next node is the head
        tempHead.next = slow.next;
        // (length - k % length)'th node is the last node
        slow.next = null;

        return tempHead.next;
    }
}
