package com.linkedlist.fast_and_slow_pointers.palindrome_linkedlist;

import com.common.datastructure.ListNode;

public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        // Initialize two pointers: slow and fast.
        ListNode slow = head;
        ListNode fast = head;

        // Find the middle of the linked list using slow and fast pointers.
        while (fast != null && fast.next != null) {
            slow = slow.next; // Move slow pointer by one step.
            fast = fast.next.next; // Move fast pointer by two steps.
        }

        // If the length of the linked list is odd, move slow pointer by one step.
        if (fast != null) slow = slow.next;

        // Reverse the second half of the linked list.
        ListNode reverseHead = reverse(slow);

        // Compare the first half and the reversed second half of the linked list.
        while (reverseHead != null) {
            if (head.val != reverseHead.val) return false; // If values don't match, return false.

            head = head.next; // Move head pointer of first half by one step.
            reverseHead = reverseHead.next; // Move head pointer of reversed second half by one step.
        }

        // If all values match, return true.
        return true;
    }

    // Helper method to reverse a linked list.
    private ListNode reverse(ListNode node) {
        ListNode previousNode = null;
        ListNode nextNode = null;

        while (node != null) {
            nextNode = node.next; // Store the next node of the current node.
            node.next = previousNode; // Point the current node to the previous node.
            previousNode = node; // Move the previous node pointer by one step.
            node = nextNode; // Move the current node pointer by one step.
        }

        // Return the new head of the reversed linked list.
        return previousNode;
    }
}

