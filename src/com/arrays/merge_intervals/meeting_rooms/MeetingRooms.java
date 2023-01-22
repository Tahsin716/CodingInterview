package com.arrays.merge_intervals.meeting_rooms;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MeetingRooms {
    public boolean canAttendMeetings(List<Interval> intervals) {
        // Sort the intervals list in ascending order of start time
        Collections.sort(intervals, Comparator.comparingInt(current -> current.start));

        for (int i = 1; i < intervals.size(); i++) {
            // If the previous interval's end > current interval's start
            // then there is an overlap, so we cannot participate in that meeting
            if (intervals.get(i - 1).end > intervals.get(i).start) {
                return false;
            }
        }

        return true;
    }

    private class Interval {
      int start, end;
      Interval(int start, int end) {
          this.start = start;
          this.end = end;
      }
    }
}
