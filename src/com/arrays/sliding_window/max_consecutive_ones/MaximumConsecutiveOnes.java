package com.arrays.sliding_window.max_consecutive_ones;

public class MaximumConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        int start = 0, end = 0, maxLength = 0;

        // If currentNum == 1, find window size and assign max window size to maxLength
        // else currentNum == 0, so move start = end
        while (end < nums.length) {
            if (nums[end] == 1) {
                maxLength = Math.max(maxLength, end - start + 1);
                end++;
            } else {
                end++;
                start = end;
            }
        }

        return maxLength;
    }
}
