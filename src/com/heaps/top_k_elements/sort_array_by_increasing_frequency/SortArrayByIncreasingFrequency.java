package com.heaps.top_k_elements.sort_array_by_increasing_frequency;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class SortArrayByIncreasingFrequency {
    public int[] frequencySort(int[] nums) {
        // Frequency count of each integer
        Map<Integer, Integer> map = new HashMap<>();

        // Keep the Map.Entry in priority queue, if the count of two number is equal, sort
        // them in descending order of the number/map.getKey()
        // else sort them in ascending order of frequency
        PriorityQueue<Map.Entry<Integer, Integer>> heap =
                new PriorityQueue<>((current, next) -> current.getValue() == next.getValue()
                        ? next.getKey() - current.getKey(): current.getValue() - next.getValue());

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            heap.offer(entry);
        }

        int[] result = new int[nums.length];
        int index = 0;

        while (heap.size() > 0) {
            Map.Entry<Integer, Integer> entry = heap.poll();
            int count = entry.getValue();

            // Insert the total number(count) of elements (entry.getKey()) inside the
            // result array
            while (count > 0) {
                result[index] = entry.getKey();
                count--;
                index++;
            }
        }

        return result;
    }
}
