package com.greedy.task_scheduler;

import java.util.Arrays;

public class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        // an array to keep track of frequency of each task
        int[] frequencies = new int[26];

        // increment frequency of task in the array
        for(char task: tasks) {
            frequencies[task - 'A']++;
        }

        // sort the frequencies in ascending order
        Arrays.sort(frequencies);

        // get the maximum frequency of tasks
        int maxFrequency = frequencies[25] - 1;
        // calculate the idle time between tasks
        int idleTime = maxFrequency * n;

        // Iterate over rest of the array and reduce the idle space count
        // If the frequencies[i] <= 0, we can break out of the loop, as the array is sorted
        // the rest of the values in frequencies will be <= 0
        for(int i = 24; i >= 0 && frequencies[i] > 0; i--) {
            // subtract the idle time between this task and maxFrequency
            idleTime -= Math.min(frequencies[i], maxFrequency);
        }

        // Handle cases when spaces become negative
        idleTime = Math.max(idleTime, 0);

        // return total time taken to complete all tasks
        return idleTime + tasks.length;
    }
}

