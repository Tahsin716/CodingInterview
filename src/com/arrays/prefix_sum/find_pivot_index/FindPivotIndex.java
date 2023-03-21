package com.arrays.prefix_sum.find_pivot_index;

public class FindPivotIndex {
    public int pivotIndex(int[] nums) {
        int sum = 0, leftSum = 0;

        // Calculate the sum of all the numbers
        for (int num : nums) {
            sum += num;
        }

        // Calculate the prefixSum and check if prefixSum equals prefixSum == sum - prefixSum - nums[i]
        // then we found the pivot index, for which leftSum == rightSum, so return the index
        for (int i = 0; i < nums.length; i++) {
            if (leftSum == sum - leftSum - nums[i]) return i;

            leftSum += nums[i];
        }

        // No pivot index was found
        return -1;
    }
}
