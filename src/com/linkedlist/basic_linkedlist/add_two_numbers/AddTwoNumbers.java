package com.linkedlist.basic_linkedlist.add_two_numbers;

import com.common.datastructure.ListNode;

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode tempHead = new ListNode(-1);
        ListNode node = tempHead;
        int carry = 0;

        // Iterate while either one of the condition is true
        // l1 != null or l2 != null or carry != 0
        while (l1 != null || l2 != null || carry != 0) {
            // If either l1 or l2 == null, then their value is 0
            // otherwise assign the value of l1 and l2
            int a = l1 != null ? l1.val : 0;
            int b = l2 != null ? l2.val : 0;

            // Find the sum of a and b along with carry from previous calculation
            // calculate sum and carry
            int sum = a + b + carry;
            carry = sum / 10;
            sum = sum % 10;

            // create a new node with sum and assign it to current nodes next
            node.next = new ListNode(sum);
            // shift current node to next node
            node = node.next;

            // If l1 is not null shift l1 to next node
            // If l2 is not null shift l2 to next node
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        return tempHead.next;
    }
}
