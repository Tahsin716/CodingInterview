package com.greedy.maximum_number_of_events_that_can_be_attended;

import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeSet;

public class MaximumNumberOfEventsThatCanBeAttended_TreeSet {
    public int maxEvents(int[][] events) {
        // sort the events by their ending date in increasing order
        Arrays.sort(events, Comparator.comparingInt(a -> a[1]));

        // set to keep track of which days are available
        TreeSet<Integer> availableDays = new TreeSet<>();

        // add all days to the set
        for (int i = 1; i <= 100000; i++) {
            availableDays.add(i);
        }

        int count = 0; // count of attended events

        for (int[] event : events) {
            // get the start and end dates of the current event
            int start = event[0];
            int end = event[1];

            // get the earliest available day for the event
            Integer earliestDay = availableDays.ceiling(start);

            // if no available day exists, continue to the next event
            if (earliestDay == null || earliestDay > end) {
                continue;
            }

            // remove the earliest available day from the set and increase the count
            availableDays.remove(earliestDay);
            count++;
        }

        return count;
    }
}

