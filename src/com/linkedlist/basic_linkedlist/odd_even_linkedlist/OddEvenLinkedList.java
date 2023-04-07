package com.linkedlist.basic_linkedlist.odd_even_linkedlist;

import com.common.datastructure.ListNode;

public class OddEvenLinkedList {
    public ListNode oddEvenList(ListNode head) {
        if (head == null) // if the list is empty, return null
            return null;

        ListNode odd = head; // initialize odd pointer to the first node
        ListNode even = odd.next; // initialize even pointer to the second node
        ListNode evenHead = even; // save the head of even list for later

        while (even != null && even.next != null) { // iterate until the end of the list or the even list is empty
            odd.next = even.next; // connect odd to the next odd node
            odd = odd.next; // move odd to the next odd node
            even.next = odd.next; // connect even to the next even node
            even = even.next; // move even to the next even node
        }

        odd.next = evenHead; // connect the end of odd list to the head of even list

        return head; // return the modified list
    }
}

