package com.heaps.top_k_elements.kth_largest_element_in_an_array;

import java.util.PriorityQueue;

public class KthLargestElementInAnArray {
    public int findKthLargest(int[] nums, int k) {
        // Use minHeap to keep the elements in ascending order
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((current, next) -> current - next);

        for (int num : nums) {
            minHeap.offer(num);

            // If the size of the heap exceeds k, pop the elements
            // out of minHeap to keep its size == k, as the heap is in ascending order,
            // and we are popping out elements if they exceed k,this will make sure that the remaining
            // k elements are the max k elements, with the element at the top of the heap being the
            // Kth largest element
            if (minHeap.size() > k) minHeap.poll();
        }

        return minHeap.peek();
    }
}
