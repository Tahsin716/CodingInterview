package com.arrays.sliding_window.max_consecutive_ones_iii;

public class MaximumConsecutiveOnesIII {
    public int longestOnes(int[] A, int K) {
        int max = 0, start = 0, end = 0, length = A.length;
        int zeroCount = 0;

        while (end < length) {
            if (A[end] == 0) zeroCount++;

            if (zeroCount > K) {
                if (A[start] == 0) zeroCount--;
                start++;
            }

            max = Math.max(max, end - start + 1);
            end++;
        }

        return max;
    }
}
