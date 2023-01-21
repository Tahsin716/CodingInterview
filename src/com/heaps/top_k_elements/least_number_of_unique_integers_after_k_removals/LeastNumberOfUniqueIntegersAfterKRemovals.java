package com.heaps.top_k_elements.least_number_of_unique_integers_after_k_removals;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class LeastNumberOfUniqueIntegersAfterKRemovals {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        // Store numbers and their frequency in map
        Map<Integer, Integer> map = new HashMap<>();
        // Keep the Map.Entry in PriorityQueue, with the numbers with the least frequency
        // at the top, i.e. the heap is sorted in ascending order with the numbers with
        // the least frequency at the top, and numbers with most frequency at the bottom
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap =
                new PriorityQueue<>((current, next) -> current.getValue() - next.getValue());

        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            minHeap.offer(entry);
        }

        // We need to remove exactly k numbers from the list
        // to have the least number of unique integers
        while (k > 0) {
            // Get the top element from the minHeap
            // and decrement its frequency, to remove an instance of the number
            Map.Entry<Integer,Integer> entry = minHeap.peek();
            entry.setValue(entry.getValue() - 1);

            // If the frequency of the number is 0, that means we removed the number
            // from the list, so remove it from the minHeap
            if (entry.getValue() == 0) {
                minHeap.poll();
            }

            k--;
        }

        return minHeap.size();
    }
}
