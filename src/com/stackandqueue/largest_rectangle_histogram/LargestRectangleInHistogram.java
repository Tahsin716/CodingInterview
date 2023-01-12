package com.stackandqueue.largest_rectangle_histogram;

import java.util.Stack;

public class LargestRectangleInHistogram {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Integer> stack = new Stack<>();
        int[] left = new int[n];
        int[] right = new int[n];

        for (int i = 0; i < n; i++) {
            // Monotonic stack to find first index of element smaller than current element, in left side.
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) stack.pop();

            // Index before the smaller element
            left[i] = (!stack.isEmpty()) ? stack.peek() + 1 : 0;

            stack.push(i);
        }

        stack.clear();

        for (int i = n - 1; i >= 0; i--) {
            // Monotonic stack to find first index of element smaller than current element, in right side.
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) stack.pop();

            // Index before the smaller element.
            right[i] = (!stack.isEmpty()) ? stack.peek() - 1 : n - 1;

            stack.push(i);
        }

        int maxArea = -1;

        // For each bar in histogram, multiply its height the rightmost and leftmost bar
        // before the smaller element in each side
        for (int i = 0; i < n; i++) maxArea = Math.max(maxArea, heights[i] * (right[i] - left[i] + 1));

        return maxArea;
    }
}
