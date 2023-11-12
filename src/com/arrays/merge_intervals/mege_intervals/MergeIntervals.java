package com.arrays.merge_intervals.mege_intervals;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        // Sort the intervals array in ascending order based on end interval
        Arrays.sort(intervals, Comparator.comparingInt(current -> current[0]));
        // Store the merged intervals in LinkedList<int[]>
        LinkedList<int[]> result = new LinkedList<>();

        for (int[] currentInterval : intervals) {
            // If there is no interval in result, i.e. current interval is first interval
            // or if the end interval of prev interval array < current interval's start interval
            // then there is no overlapping so add the current interval to the result list
            if (result.isEmpty() || result.getLast()[1] < currentInterval[0]) {
                result.add(currentInterval);
            } else {
                // there is an overlapping, as current interval's start interval <= prev interval's end interval,
                // as array is sorted we already know prev interval's start interval < current interval's start,
                // so we only need to update what will be the end interval after merging
                // it will be max(prevInterval[1], currentInterval[1])
                result.getLast()[1] = Math.max(result.getLast()[1], currentInterval[1]);
            }
        }

        return result.toArray(new int[result.size()][]);
    }
}
