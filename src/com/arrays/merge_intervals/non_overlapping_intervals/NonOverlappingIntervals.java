package com.arrays.merge_intervals.non_overlapping_intervals;

import java.util.Arrays;
import java.util.Comparator;

public class NonOverlappingIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        // Sort the intervals array in ascending order based on end interval
        Arrays.sort(intervals, Comparator.comparingInt(current -> current[1]));

        // Set the first interval's end interval as prevEndInterval, as we will be iterating from index 1.
        // And set nonOverlappingCount = 1, as there will be at least one non-overlapping interval, since we
        // already took first interval into account
        int prevEndInterval = intervals[0][1];
        int nonOverlappingCount = 1;

        for (int i = 1; i < intervals.length; i++) {
            // If current interval's start interval >= prevEndInterval
            // then there is no overlapping, so increment nonOverlappingCount
            // and set current interval's end interval as prevEndInterval
            if (intervals[i][0] >= prevEndInterval) {
                nonOverlappingCount++;
                prevEndInterval = intervals[i][1];
            }
        }

        // The total number of overlapping interval that needs to be removed is equal to
        // length of intervals subtracted by total number of non-overlapping intervals
        // overLappingCount + nonOverlappingCount = intervals.length
        return intervals.length - nonOverlappingCount;
    }
}
