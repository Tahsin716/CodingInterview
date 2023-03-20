package com.heaps.basic_priority_queue.last_stone_weight;

import java.util.Collections;
import java.util.PriorityQueue;

public class LastStoneWeight {
    public int lastStoneWeight(int[] stones) {
        // Create a maxHeap to store the heaviest stones at the top
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        // Insert all the stones in maxHeap
        for (int stone : stones) maxHeap.offer(stone);

        // While there is more than 1 stone in the maxHeap
        // we will smash the two heaviest stones and insert the stone after subtraction of their weights
        while (maxHeap.size() > 1) {
            int x = maxHeap.poll();
            int y = maxHeap.poll();

            // Both stones are destroyed as they are equal in weight
            if (x == y) continue;

            // We take the weight after subtraction and insert it into the heap.
            y = Math.abs(x - y);
            maxHeap.offer(y);
        }

        // Check whether all stones were destroyed or not, else return the weight of the stone left
        return maxHeap.size() == 0 ? 0 : maxHeap.poll();
    }
}
