package com.stack_and_queue.max_value_of_equation;

import com.common.datastructure.Pair;

import java.util.ArrayDeque;
import java.util.Deque;

public class MaxValueOfEquation {
    // This code finds the maximum value of the equation y[i] + y[j] + |x[i] - x[j]|
    // among all pairs of i and j given a set of points and a value k.
    public int findMaxValueOfEquation(int[][] points, int k) {
        // create a deque to hold pairs of integers, where the first integer is the value of y[i]-x[i] and the second integer is the value of x[i]
        Deque<Pair<Integer, Integer>> queue = new ArrayDeque<>();
        // initialize the maximum value to a very small negative integer
        int max = Integer.MIN_VALUE;

        // loop through the array of points
        for (int[] point: points) {
            // remove the elements at the front of the deque if the difference between the current x value and the front x value is greater than k
            while (!queue.isEmpty() && point[0] - queue.peekFirst().getValue() > k) queue.pollFirst();

            // if the deque is not empty, compute the current value of the equation using the current point and the point at the front of the deque, and update the maximum value if necessary
            if (!queue.isEmpty())
                max = Math.max(max, point[1] + point[0] + queue.peekFirst().getKey());

            // remove the elements at the back of the deque if the value of y[i]-x[i] is less than or equal to the value of y[j]-x[j] for the back element of the deque
            while (!queue.isEmpty() && point[1] - point[0] >= queue.peekLast().getKey()) queue.pollLast();

            // add the current point to the back of the deque
            queue.addLast(new Pair(point[1] - point[0], point[0]));
        }

        // return the maximum value of the equation
        return max;
    }
}

