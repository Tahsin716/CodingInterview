package com.arrays.two_pointers.container_with_most_water;

public class ContainerWithMostWater {
    public int maxArea(int[] heights) {
        int start = 0, end = heights.length - 1, max = 0;
        int width, height, currentArea;

        // Use two pointer start and end to calculate the maximum area to hold the water.
        while (start < end) {

            // The width of the container would be (end - start)
            // whilst the height of the container would be min(height[start], height[end]).
            // This is because water would spill from the container if it exceeds the min height.
            width = end - start;
            height = Math.min(heights[start], heights[end]);
            currentArea = height * width;

            // Assign the max area to, max
            max = Math.max(max, currentArea);

            // Shift start or end pointer, if their height is lesser than other
            if (heights[start] < heights[end]) {
                start++;
            } else {
                end--;
            }
        }

        return max;
    }
}
