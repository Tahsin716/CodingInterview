package com.linkedlist.basic_linkedlist.merge_k_sorted_list;

import com.common.datastructure.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MergeKSortedList {
    public ListNode mergeKLists(ListNode[] lists) {
        // Keep the nodes in minHeap in ascending order of their value
        Queue<ListNode> minHeap = new PriorityQueue<>(Comparator.comparingInt(current -> current.val));

        // Iterate the list of linked lists and insert their head into the minHeap
        for (ListNode node : lists) {
            if (node != null) minHeap.add(node);
        }

        ListNode tempHead = new ListNode(-1);
        ListNode pointer = tempHead;

        while (!minHeap.isEmpty()) {
            // Assign the node from minHeap as the next node of current node
            pointer.next = minHeap.poll();
            // Shift current node to next node
            pointer = pointer.next;
            // Next node of the current list
            ListNode next = pointer.next;

            // If the next node of current node after shifting is not null, that means
            // we haven't yet reached the end of the list, so add the next node of that list
            // in the minHeap
            if (next != null) minHeap.add(next);
        }

        return tempHead.next;
    }
}
