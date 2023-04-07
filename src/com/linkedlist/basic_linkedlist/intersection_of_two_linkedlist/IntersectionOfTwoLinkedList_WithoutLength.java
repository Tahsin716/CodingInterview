package com.linkedlist.basic_linkedlist.intersection_of_two_linkedlist;

import com.common.datastructure.ListNode;

public class IntersectionOfTwoLinkedList_WithoutLength {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // initialize two pointers at the beginning of the lists
        ListNode nodeA = headA;
        ListNode nodeB = headB;

        // loop until the two pointers meet at the intersection point or both reach the end of the list
        while (nodeA != nodeB) {
            // if either pointer reaches the end of the list, move it to the head of the other list
            nodeA = nodeA == null ? headB : nodeA.next;
            nodeB = nodeB == null ? headA : nodeB.next;
        }

        // return the intersection point or null if the two lists do not intersect
        return nodeA;
    }
}

