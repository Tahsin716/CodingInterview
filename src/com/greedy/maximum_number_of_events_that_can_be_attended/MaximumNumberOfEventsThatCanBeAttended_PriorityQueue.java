package com.greedy.maximum_number_of_events_that_can_be_attended;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MaximumNumberOfEventsThatCanBeAttended_PriorityQueue {
    public int maxEvents(int[][] events) {
        // Sort events by their start day
        Arrays.sort(events, Comparator.comparingInt(a -> a[0]));

        // Create a min heap of the end days
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        int day = 1; // Current day
        int count = 0; // Number of events attended

        for (int i = 0; i < events.length || !minHeap.isEmpty(); day++) {
            // Add end date of events that start on or are before current day to the min heap
            while (i < events.length && events[i][0] <= day) {
                minHeap.offer(events[i][1]);
                i++;
            }

            // Remove events that have already ended from the min heap
            while (!minHeap.isEmpty() && minHeap.peek() < day) {
                minHeap.poll();
            }

            // Attend an event on the current day if possible
            if (!minHeap.isEmpty()) {
                minHeap.poll();
                count++;
            }
        }

        return count;
    }
}

