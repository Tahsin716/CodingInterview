package com.arrays.prefix_sum.running_sum_of_1D_array;

public class RunningSumOf1DArray {
    public int[] runningSum(int[] nums) {

        // Iterate over the array and add, nums[i] += nums[i - 1]
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }

        return nums;
    }
}
