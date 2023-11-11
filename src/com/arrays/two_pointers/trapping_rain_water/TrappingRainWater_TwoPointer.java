package com.arrays.two_pointers.trapping_rain_water;

public class TrappingRainWater_TwoPointer {
    public int trap(int[] height) {
        int n = height.length;
        int result = 0, left = 0, right = n - 1;

        // Assign maxLeft = first height, and maxRight = last height
        // Formula to calculate trapped water = min(leftMax[i], rightMax[i]) - heights[i]
        int maxLeft = height[left], maxRight = height[right];

        while (left < right) {

            // We are taking the min between height[left] and height[right]
            // It is guaranteed there is a building greater than or equal to height[left] (maxLeft)
            // so we can ignore height[right], and the formula stays the same
            //
            // From the DP solution:
            // height:   [0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1]
            // maxLeft:  [0, 0, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3]
            // maxRight: [3, 3, 3, 3, 3, 3, 3, 2, 2, 2, 1, 0]
            // min(L,R): [0, 0, 1, 1, 2, 2, 2, 2, 2, 2, 1, 0]
            if (height[left] < height[right]) {
                // We are taking the max of leftHeight
                maxLeft = Math.max(maxLeft, height[left]);
                // Similar to leftMax[i] - height[i]
                result += maxLeft - height[left];
                left++;
            } else {
                // We are taking the max of rightHeight
                maxRight = Math.max(maxRight, height[right]);
                // Similar to rightMax[i] - height[i]
                result += maxRight - height[right];
                right--;
            }
        }

        return result;
    }
}
