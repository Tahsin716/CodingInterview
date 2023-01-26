package com.linkedlist.fast_and_slow_pointers.reorder_list;

import com.common.datastructure.ListNode;

public class ReorderList {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;

        // Use fast and slow pointer to find the middle node
        ListNode mid = findMid(head);
        // Reverse the linked list after middle node, and return the head node of reversed list
        ListNode reversedHead = reverseList(mid.next);

        // Cut the list into two list, head -> mid, list and reversed list from mid + 1 -> tail
        mid.next = null;

        ListNode headNext, reversedHeadNext;

        // While neither one of the list and reversed list is null
        while (head != null && reversedHead != null) {
            // Store the next node of both the list and reversed list
            headNext = head.next;
            reversedHeadNext = reversedHead.next;

            // Assign head of reversed lists next node to, list's next node
            reversedHead.next = head.next;
            // Assign next node of list's head to head of the reversed list
            head.next = reversedHead;

            // Assign head to stored head.next and reversedHead to store reversedHead.next
            // to move to the next node of each list
            head = headNext;
            reversedHead = reversedHeadNext;
        }

        return;
    }

    private ListNode findMid(ListNode head) {
        ListNode slow = head, fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    private ListNode reverseList(ListNode head) {
        if (head == null) return null;

        ListNode node = head, temp = head;
        ListNode reversedHead = null;

        while (node != null) {
            node = node.next;
            temp.next = reversedHead;
            reversedHead = temp;
            temp = node;
        }

        return reversedHead;
    }
}
