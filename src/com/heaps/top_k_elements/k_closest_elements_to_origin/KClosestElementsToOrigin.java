package com.heaps.top_k_elements.k_closest_elements_to_origin;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class KClosestElementsToOrigin {
    public int[][] kClosest(int[][] points, int k) {
        // Map the int[] points with their distance from origin
        Map<int[], Integer> map = new HashMap<>();
        // Create a maxHeap to store the int[] points with their distance in descending order
        // to keep the farthest point at the top
        PriorityQueue<Map.Entry<int[], Integer>> maxHeap =
                new PriorityQueue<>((current, next) -> next.getValue() - current.getValue());

        for (int[] coordinates : points) {
            map.put(coordinates, getDistanceFromOrigin(coordinates));
        }

        for (Map.Entry<int[], Integer> entry : map.entrySet()) {
            maxHeap.offer(entry);

            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        int[][] ans = new int[k][2];

        for (int i = 0; i < k; i++) {
            int[] coordinates = maxHeap.peek().getKey();
            ans[i][0] = coordinates[0];
            ans[i][1] = coordinates[1];
            maxHeap.poll();
        }

        return ans;
    }

    private int getDistanceFromOrigin(int[] coordinates) {
        // Since we only need distance for comparison, we can just use
        // x2 + y2 for simplicity
        return (coordinates[0] * coordinates[0]) + (coordinates[1] * coordinates[1]);
    }
}
