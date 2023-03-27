package com.maths.missing_number;

public class MissingNumber_CumulativeSum {
    public int missingNumber(int[] nums) {
        // initialize two variables to store cumulative sum
        int cumulativeArraySum = 0;
        int cumulativeSumMissing = nums.length;

        // iterate over the array and update the cumulative sum variables
        for (int i = 0; i < nums.length; i++) {
            cumulativeArraySum += nums[i];
            cumulativeSumMissing += i;
        }

        // return the difference between cumulative sum of 0 to n and the sum of the array elements
        return cumulativeSumMissing - cumulativeArraySum;
    }
}

