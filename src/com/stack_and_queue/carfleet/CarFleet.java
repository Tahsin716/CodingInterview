package com.stack_and_queue.carfleet;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

class CarFleet {
    public int carFleet(int target, int[] position, int[] speed) {
        int length = position.length;
        int[][] combined = new int[length][2];

        // Combine [position, speed]
        for (int i = 0; i < length; i++) {
            combined[i][0] = position[i];
            combined[i][1] = speed[i];
        }

        // Sort the cars by their starting positions in ascending order -> [0, 3, 5, 8, 10]
        Arrays.sort(combined, Comparator.comparingInt(current -> current[0]));
        Stack<Double> stack = new Stack<>();

        for (int i = length - 1; i >= 0; i--) {
            // Time = distance / speed
            double currentTime = (double)(target - combined[i][0]) / combined[i][1];

            // Car will reach destination later than the car before it, so a new fleet is created.
            if (stack.isEmpty() || currentTime > stack.peek()) {
                stack.push(currentTime);
            }
        }

        return stack.size();
    }
}