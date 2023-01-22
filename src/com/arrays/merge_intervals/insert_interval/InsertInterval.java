package com.arrays.merge_intervals.insert_interval;

import java.util.LinkedList;

public class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        LinkedList<int[]> result = new LinkedList<>();
        int index = 0;

        // While we haven't exceeded the intervals array boundary, and the current interval's end < new interval's start
        // that means there is no overlapping as they are smaller than the interval we want to insert
        // so just add the intervals into the result list
        while (index < intervals.length && intervals[index][1] < newInterval[0]) {
            result.add(intervals[index++]);
        }

        // While we haven't exceeded the intervals array boundary
        // and the current interval's start index <= new interval's end interval
        // then there is overlapping, so we need to merge the current interval with new interval, and update new interval
        // newInterval start interval = min(currentInterval[0], newInterval[0])
        // newInterval end interval = max(currentInterval[1], newInterval[1])
        while (index < intervals.length && intervals[index][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[index][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[index][1]);
            index++;
        }

        // Add the updated merged newInterval into the list
        result.add(newInterval);

        // Add the remaining intervals into the list
        while (index < intervals.length) {
            result.add(intervals[index++]);
        }

        return result.toArray(new int[result.size()][]);
    }
}
