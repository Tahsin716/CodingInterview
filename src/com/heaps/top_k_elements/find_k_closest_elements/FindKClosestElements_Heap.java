package com.heaps.top_k_elements.find_k_closest_elements;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class FindKClosestElements_Heap {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        // Create a PriorityQueue with custom sort, if abs(current - x) == abs(next - x),
        // then insert the number in descending order, else insert the number in ascending order
        // of closest to x
        PriorityQueue<Integer> maxHeap =
                new PriorityQueue<>((current, next) -> Math.abs(current - x) == Math.abs(next - x)
                        ? next - current : Math.abs(next - x) - Math.abs(current - x));

        for (int num : arr) {
            maxHeap.offer(num);

            // We keep the size of the heap == k
            if (maxHeap.size() > k) maxHeap.poll();
        }

        List<Integer> result = new ArrayList<>();

        while (maxHeap.size() > 0) {
            result.add(maxHeap.poll());
        }

        // The result has to be in sorted order as well
        Collections.sort(result);

        return result;
    }
}
