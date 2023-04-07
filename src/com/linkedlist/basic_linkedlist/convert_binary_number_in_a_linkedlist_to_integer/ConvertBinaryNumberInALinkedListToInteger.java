package com.linkedlist.basic_linkedlist.convert_binary_number_in_a_linkedlist_to_integer;

import com.common.datastructure.ListNode;

public class ConvertBinaryNumberInALinkedListToInteger {
    public int getDecimalValue(ListNode head) {
        int sum = 0; // stores the decimal value of the linked list
        ListNode node = head; // current node in the linked list

        // traverse the linked list until the end
        while (node != null) {
            sum *= 2; // left shift sum by 1 bit
            sum += node.val; // add the value of the current node to sum
            node = node.next; // move to the next node in the linked list
        }

        return sum; // return the decimal value
    }
}

