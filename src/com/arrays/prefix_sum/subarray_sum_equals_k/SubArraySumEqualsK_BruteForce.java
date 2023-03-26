package com.arrays.prefix_sum.subarray_sum_equals_k;

public class SubArraySumEqualsK_BruteForce {
    public int subarraySum(int[] nums, int k) {
        // Initialize a variable count to keep track of the number of subarrays
        int count = 0;

        // Loop through the array starting from each index
        for (int start = 0; start < nums.length; start++) {
            // Initialize a variable sum to keep track of the sum of subarrays
            int sum = 0;

            // Loop through the array from the starting index to the end
            for (int end = start; end < nums.length; end++) {
                // Add the current element to the sum
                sum += nums[end];

                // If the sum equals the target value k, increment the count
                if (sum == k)
                    count++;
            }
        }

        // Return the count of subarrays that sum up to k
        return count;
    }
}
