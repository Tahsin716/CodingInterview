package com.stack_and_queue.largest_rectangle_histogram;

import java.util.Stack;

public class LargestRectangleInHistogram {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Integer> stack = new Stack<>();
        int[] left = new int[n];
        int[] right = new int[n];

        // Calculate the left boundaries for each bar in the histogram
        for (int i = 0; i < n; i++) {
            // Monotonic stack: Find the first index of an element smaller than the current element on the left side
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) stack.pop();

            // Index before the smaller element
            left[i] = (!stack.isEmpty()) ? stack.peek() + 1 : 0;

            stack.push(i);
        }

        stack.clear(); // Clear the stack for reuse

        // Calculate the right boundaries for each bar in the histogram
        for (int i = n - 1; i >= 0; i--) {
            // Monotonic stack: Find the first index of an element smaller than the current element on the right side
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) stack.pop();

            // Index before the smaller element
            right[i] = (!stack.isEmpty()) ? stack.peek() - 1 : n - 1;

            stack.push(i);
        }

        int maxArea = -1;

        // For each bar in the histogram, calculate the area by multiplying its height with the distance
        // between the rightmost and leftmost bars before the smaller element on each side
        for (int i = 0; i < n; i++) maxArea = Math.max(maxArea, heights[i] * (right[i] - left[i] + 1));

        return maxArea;
    }
}

