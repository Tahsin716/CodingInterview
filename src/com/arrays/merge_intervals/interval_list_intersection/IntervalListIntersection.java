package com.arrays.merge_intervals.interval_list_intersection;

import java.util.ArrayList;
import java.util.List;

public class IntervalListIntersection {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int i = 0, j = 0;
        List<int[]> result = new ArrayList<>();

        // Similar to merging list/array in merge sort to merge two sorted list/array
        while (i < firstList.length && j < secondList.length) {

            int firstStart = firstList[i][0], firstEnd = firstList[i][1];
            int secondStart = secondList[j][0], secondEnd = secondList[j][1];

            // If there is a criss-cross in intervals, i.e.
            // A.start <= B.end && B.start <= A.end then sure there is an overlap
            // So to the intersecting interval is:
            // startInterval = max(A.start, B.start)
            // endInterval = min(A.end, B.end)
            if (firstStart <= secondEnd && secondStart <= firstEnd) {
                int start = Math.max(firstStart, secondStart);
                int end = Math.min(firstEnd, secondEnd);
                result.add(new int[]{start, end});
            }

            // If A.end <= B.end that means we have exhausted the interval range in A
            // so point to the next interval in A
            if (firstEnd <= secondEnd) {
                i++;
            } else {
                j++;
            }
        }

        return result.toArray(new int[result.size()][]);
    }

}
