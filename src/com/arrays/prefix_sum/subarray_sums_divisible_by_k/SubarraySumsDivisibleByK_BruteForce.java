package com.arrays.prefix_sum.subarray_sums_divisible_by_k;

public class SubarraySumsDivisibleByK_BruteForce {
    public int subarraysDivByK(int[] nums, int k) {
        int count = 0;

        // iterate over all possible subarrays
        for (int start = 0; start < nums.length; start++) {
            int sum = 0;
            for (int end = start; end < nums.length; end++) {
                // calculate the sum of the subarray
                sum += nums[end];
                // take the modulus of the sum by k
                sum %= k;

                // if the modulus is negative, add k to make it positive
                if (sum < 0) sum += k;

                // if the modulus is zero, the subarray is divisible by k
                if (sum % k == 0) count++;
            }
        }

        return count;
    }
}

