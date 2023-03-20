package com.heaps.k_way_merge.kth_smallest_element_in_a_sorted_matrix;

import java.util.Collections;
import java.util.PriorityQueue;

public class KthSmallestElementInASortedMatrix_MaxHeap {
    public int kthSmallest(int[][] matrix, int k) {

        // Get the size of the matrix.
        int n = matrix.length;

        // Create a max heap using a priority queue with reverse order comparator.
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        // Iterate through each cell of the matrix and add its value to the max heap.
        // If the size of the heap becomes greater than k, remove the largest element from the heap.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                maxHeap.offer(matrix[i][j]);
                if (maxHeap.size() > k) maxHeap.poll();
            }
        }

        // The kth smallest, element is the largest element in the max heap.
        return maxHeap.poll();
    }
}

