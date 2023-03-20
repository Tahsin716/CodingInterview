package com.heaps.k_way_merge.merge_k_sorted_lists;

import com.common.datastructure.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Merge_K_Sorted_Lists {
    public ListNode mergeKLists(ListNode[] lists) {
        // Create a minHeap priority queue to store the linked lists.
        // The queue is sorted based on the value of the nodes.
        Queue<ListNode> minHeap = new PriorityQueue<>(Comparator.comparingInt(current -> current.val));

        // Add each linked list to the minHeap queue.
        for (ListNode node : lists) {
            if (node != null) minHeap.add(node);
        }

        // Create a dummy head node for the merged list.
        ListNode tempHead = new ListNode(-1);
        // Create a pointer to the dummy head node.
        ListNode pointer = tempHead;

        // While there are still nodes in the minHeap queue, extract the smallest one.
        while (!minHeap.isEmpty()) {
            pointer.next = minHeap.poll();
            pointer = pointer.next;
            // If the extracted node has a next node, add it to the minHeap queue.
            ListNode next = pointer.next;
            if (next != null) minHeap.add(next);
        }

        // Return the merged list.
        return tempHead.next;
    }
}
