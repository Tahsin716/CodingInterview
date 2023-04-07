package com.linkedlist.basic_linkedlist.intersection_of_two_linkedlist;

import com.common.datastructure.ListNode;

public class IntersectionOfTwoLinkedList_WithLength {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // Get the lengths of the two linked lists
        int lenA = getLength(headA);
        int lenB = getLength(headB);

        // If list A is longer than list B, move headA forward by the difference
        if (lenA > lenB) {
            int diff = lenA - lenB;
            while (diff-- > 0) {
                headA = headA.next;
            }
        }
        // If list B is longer than list A, move headB forward by the difference
        else {
            int diff = lenB - lenA;
            while (diff-- > 0) {
                headB = headB.next;
            }
        }

        // Iterate through both lists until the intersection node is found or the end is reached
        while (headA != null && headB != null && headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }

        // Return the intersection node, or null if there is no intersection
        return headA;
    }

    // Helper function to get the length of a linked list
    private int getLength(ListNode node) {
        int length = 0;
        while (node != null) {
            length++;
            node = node.next;
        }
        return length;
    }
}

