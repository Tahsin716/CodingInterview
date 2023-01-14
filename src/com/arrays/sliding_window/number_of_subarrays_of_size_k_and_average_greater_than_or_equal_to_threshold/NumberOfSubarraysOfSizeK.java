package com.arrays.sliding_window.number_of_subarrays_of_size_k_and_average_greater_than_or_equal_to_threshold;

public class NumberOfSubarraysOfSizeK {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int start = 0, end = 0, length = arr.length, windowSize, ans = 0, sum = 0;

        // Iterate and add the num to find sum
        // If windowSize == k, find the average
        // and increment result if average >= threshold
        while (end < length) {
            sum += arr[end];
            windowSize = end - start + 1;

            if (windowSize == k) {
                int average = sum / k;
                ans = average >= threshold ? ans + 1 : ans;
                sum -= arr[start];
                start++;
            }

            end++;
        }

        return ans;
    }
}
