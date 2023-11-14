package com.stack_and_queue.sliding_window_maximum;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> monotonicQueue = new ArrayDeque<>(); // Monotonic deque to store indices of elements
        List<Integer> result = new ArrayList<>(); // List to store the maximum elements in each window

        for (int i = 0; i < nums.length; i++) {
            // First element is out of the window, so remove it
            if (!monotonicQueue.isEmpty() && monotonicQueue.getFirst() <= i - k)
                monotonicQueue.removeFirst();

            // Monotonic Deque: Remove elements smaller than the current element from the back
            while (!monotonicQueue.isEmpty() && nums[monotonicQueue.getLast()] < nums[i])
                monotonicQueue.removeLast();

            // Add the current index to the deque
            monotonicQueue.addLast(i);

            // Window size is valid, so insert the maximum element in the window to the result list
            if (i + 1 - k >= 0)
                result.add(nums[monotonicQueue.getFirst()]);
        }

        // Convert the result list to an array and return
        return result.stream().mapToInt(i -> i).toArray();
    }
}

