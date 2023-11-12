package com.arrays.sliding_window.max_consecutive_ones_iii;

public class MaximumConsecutiveOnesIII {
    // Function to find the length of the longest subarray with at most K zeros
    public int longestOnes(int[] A, int K) {
        // Initialize variables: max length, start and end pointers, array length, and zero count
        int max = 0, start = 0, end = 0, length = A.length;
        int zeroCount = 0;

        // Iterate through the array using the sliding window approach
        while (end < length) {
            // Check if the current element is zero and update zero count
            if (A[end] == 0) {
                zeroCount++;
            }

            // If the number of zeros exceeds the allowed limit (K),
            // move the start pointer to shrink the window
            if (zeroCount > K) {
                // If the element at the start is zero, decrement zero count
                if (A[start] == 0) {
                    zeroCount--;
                }
                // Move the start pointer to the next position
                start++;
            }

            // Update the maximum length encountered so far
            max = Math.max(max, end - start + 1);

            // Move the end pointer to expand the window
            end++;
        }

        // Return the maximum length of the subarray with at most K zeros
        return max;
    }
}
