package com.stack_and_queue.sliding_window_maximum;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> monotonicQueue = new ArrayDeque<>();
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            // First element is out of window, so remove it
            if (!monotonicQueue.isEmpty() && monotonicQueue.getFirst() <= i - k) monotonicQueue.removeFirst();

            // Monotonic Deque to insert only max elements in a window, the front element in deque is the max element in window
            while (!monotonicQueue.isEmpty() && nums[monotonicQueue.getLast()] < nums[i]) monotonicQueue.removeLast();

            monotonicQueue.addLast(i);

            // Window size is valid, so insert the first element of the deque which is the maximum element in the window
            if (i + 1 - k >= 0) result.add(nums[monotonicQueue.getFirst()]);
        }

        return result.stream().mapToInt(i -> i).toArray();
    }
}
