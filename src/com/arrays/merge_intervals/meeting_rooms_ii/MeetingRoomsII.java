package com.arrays.merge_intervals.meeting_rooms_ii;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MeetingRoomsII {
    public int minMeetingRooms(List<Interval> intervals) {
        // Sort the intervals list in ascending order of interval start time
        Collections.sort(intervals, Comparator.comparingInt(current -> current.start));
        // Sort the interval in PriorityQueue in ascending order of interval end time
        PriorityQueue<Interval> queue = new PriorityQueue<>(Comparator.comparingInt(current -> current.end));
        int minRooms = 0;

        for (Interval interval : intervals) {
            // While the queue is not empty and the current interval's start >= queue's top interval's end
            // then there is no overlapping, so remove the top interval from queue, to check overlapping with
            // previous intervals
            while (!queue.isEmpty() && interval.start >= queue.peek().end) queue.poll();

            queue.offer(interval);
            // queue.size() indicates the number of intervals in the queue, which are overlapping
            minRooms = Math.max(minRooms, queue.size());
        }

        return minRooms;
    }

    private class Interval {
        int start, end;
        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
