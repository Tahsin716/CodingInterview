package com.heaps.two_heaps.sliding_window_median;

import java.util.Collections;
import java.util.PriorityQueue;

public class SlidingWindowMedian {
    public double[] medianSlidingWindow(int[] nums, int k) {
        int length = nums.length;

        // If either the input array is empty or the sliding window size is zero, return an empty array
        if (length == 0 || k == 0)
            return new double[0];

        // Create an array to hold the medians for each sliding window
        double[] ans = new double[length - k + 1];

        // Create two priority queues, one min heap and one max heap
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        // Iterate over the input array
        for (int i = 0; i < length; i++) {

            // Add the current element to the max heap
            maxHeap.add(nums[i]);

            // Move the maximum element from the max heap to the min heap
            minHeap.add(maxHeap.poll());

            // If the min heap is larger than the max heap, move the minimum element from the min heap to the max heap
            if (minHeap.size() > maxHeap.size())
                maxHeap.add(minHeap.poll());

            // Once the sliding window has reached size k, calculate the median
            if (i >= k - 1) {

                // Add the median to the array
                ans[i - k + 1] = getMedian(maxHeap, minHeap);

                // Remove the first element of the sliding window from the heaps
                int firstWindowElement = nums[i - k + 1];

                if (firstWindowElement > maxHeap.peek()) {
                    minHeap.remove(firstWindowElement);
                }
                else {
                    maxHeap.remove(firstWindowElement);
                }
            }
        }

        // Return the array of medians
        return ans;
    }

    // Helper function to calculate the median from the two priority queues
    private double getMedian(PriorityQueue<Integer> maxHeap, PriorityQueue<Integer> minHeap) {
        return maxHeap.size() == minHeap.size()
                ? ((double)maxHeap.peek() + (double)minHeap.peek()) / 2.0
                : maxHeap.peek();
    }
}

