package com.arrays.cyclic_sort.missing_number;

public class MissingNumber_Summation {
    public int missingNumber(int[] nums) {
        int cumulativeArraySum = 0;
        int cumulativeSumMissing = nums.length;

        // Calculate the sum of all index
        // Also calculate the sum of all numbers in nums array
        // Subtract sumOfIndices with sumOfArray to find the missing number
        for (int i = 0; i < nums.length; i++) {
            cumulativeArraySum += nums[i];
            cumulativeSumMissing += i;
        }

        return cumulativeSumMissing - cumulativeArraySum;
    }
}
