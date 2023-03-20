package com.heaps.k_way_merge.kth_smallest_element_in_a_sorted_matrix;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthSmallestElementInASortedMatrix_MinHeap {
    public int kthSmallest(int[][] matrix, int k) {

        // Create a min heap using a priority queue.
        // The comparator is a lambda function that compares the values of the cells represented by two arrays of integers.
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> matrix[a[0]][a[1]]));

        // Add the first column of cells to the min heap.
        for (int i = 0; i < matrix.length; i++) {
            minHeap.offer(new int[]{i, 0});
        }

        // Remove k - 1 elements from the min heap.
        // Each time, add the next cell in the same row to the min heap if it exists.
        for (int i = 0; i < k - 1; i++) {
            int[] currentCell = minHeap.poll();
            int currentRow = currentCell[0];
            int currentColumn = currentCell[1];

            if (currentColumn != matrix.length - 1) {
                minHeap.offer(new int[]{currentRow, currentColumn + 1});
            }
        }

        // The kth smallest, element is the value in the cell at the top of the min heap after removing k - 1 elements.
        int[] result = minHeap.poll();
        int row = result[0];
        int column = result[1];

        return matrix[row][column];
    }
}

