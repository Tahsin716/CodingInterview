package com.heaps.top_k_elements.top_k_frequent_elements;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        // Use minHeap to keep the numbers in ascending order of their frequency/count
        HashMap<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(Comparator.comparingInt(map::get));

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (int num : map.keySet()) {
            minHeap.add(num);

            // We will keep the size of the minHeap as k
            // if the size of the minHeap exceeds k, we will poll the
            // element with the least frequency in the heap out
            if (minHeap.size() > k) minHeap.poll();
        }

        int[] ans = new int[k];

        // As we need the return the answer in descending order of frequency
        // Iterate from i: k - 1 -> 0
        for (int i = k - 1; i >= 0; i--) {
            ans[i] = minHeap.poll();
        }

        return ans;
    }
}
