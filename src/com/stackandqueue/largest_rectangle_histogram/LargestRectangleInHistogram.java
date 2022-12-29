package com.stackandqueue.largest_rectangle_histogram;

import java.util.Stack;

public class LargestRectangleInHistogram {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Integer> stack = new Stack<>();
        int[] left = new int[n];
        int[] right = new int[n];

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) stack.pop();

            left[i] = (!stack.isEmpty()) ? stack.peek() + 1 : 0;

            stack.push(i);
        }

        stack.clear();

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) stack.pop();

            right[i] = (!stack.isEmpty()) ? stack.peek() - 1 : n - 1;

            stack.push(i);
        }

        int maxArea = -1;

        for (int i = 0; i < n; i++) maxArea = Math.max(maxArea, heights[i] * (right[i] - left[i] + 1));

        return maxArea;
    }
}
