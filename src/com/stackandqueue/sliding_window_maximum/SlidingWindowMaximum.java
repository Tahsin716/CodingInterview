package com.stackandqueue.sliding_window_maximum;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> monotonicQueue = new ArrayDeque<>();
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (!monotonicQueue.isEmpty() && monotonicQueue.getFirst() <= i - k) monotonicQueue.removeFirst();

            while (!monotonicQueue.isEmpty() && nums[monotonicQueue.getLast()] < nums[i]) monotonicQueue.removeLast();

            monotonicQueue.addLast(i);

            if (i + 1 - k >= 0) result.add(nums[monotonicQueue.getFirst()]);
        }

        return result.stream().mapToInt(i -> i).toArray();
    }
}
