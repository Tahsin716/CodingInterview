package com.arrays.sliding_window.maximum_average_subarray_i;

public class MaximumAverageSubarrayI {
    public double findMaxAverage(int[] nums, int k) {
        int start = 0, end = 0, windowSize;
        double ans = (double)Integer.MIN_VALUE, sum = 0.0;

        while (end < nums.length) {
            sum += nums[end];
            windowSize = end - start + 1;

            // window size == k, valid window, so find the max average
            // subtract num[start] from sum as we are moving left pointer
            if (windowSize == k) {
                ans = Math.max(ans, sum / k);
                sum -= nums[start];
                start++;
            }

            end++;
        }

        return ans;
    }
}
