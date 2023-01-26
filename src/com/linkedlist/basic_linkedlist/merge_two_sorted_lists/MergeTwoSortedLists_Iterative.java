package com.linkedlist.basic_linkedlist.merge_two_sorted_lists;

import com.common.datastructure.ListNode;

public class MergeTwoSortedLists_Iterative {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode tempHead = new ListNode(-1);
        ListNode node = tempHead;

        // Iterate while neither one of the list is null
        // Assign node.next with the smallest node between l1 and l2
        // and then shift that smallest node to the next node
        // then move node to node.next
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                node.next = l1;
                l1 = l1.next;
            } else {
                node.next = l2;
                l2 = l2.next;
            }
            node = node.next;
        }

        // If l1 is not null, then assign the remaining elements of l1, to node.next
        if (l1 != null) node.next = l1;

        // If l2 is not null, then assign the remaining elements of l2, to node.next
        if (l2 != null) node.next = l2;

        return tempHead.next;
    }
}
