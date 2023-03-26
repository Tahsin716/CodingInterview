package com.arrays.two_pointers.three_sum_closest;

import java.util.Arrays;

public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        // Sort the array in ascending order to simplify the search
        Arrays.sort(nums);

        // Initialize variables for tracking the closest sum and its distance from the target
        int min = Integer.MAX_VALUE; // arbitrarily large value
        int closest = 0;

        // Loop through the array, examining each possible triple of integers
        for (int i = 0; i < nums.length - 2; i++) {
            // Skip duplicates in the array to avoid unnecessary computation
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            // Use two pointers to traverse the remaining part of the array
            int start = i + 1;
            int end = nums.length - 1;

            while (start < end) {
                // Calculate the sum of the three integers at the current indices
                int sum = nums[start] + nums[end] + nums[i];

                // Update the closest sum and its distance from the target if needed
                if (Math.abs(sum - target) < min) {
                    min = Math.abs(sum - target);
                    closest = sum;
                }

                // Move the pointers based on whether the sum is too high, too low, or just right
                if (sum - target > 0) {
                    end--;
                } else if (sum - target == 0) {
                    return target;
                } else {
                    start++;
                }
            }
        }

        // Return the closest sum found
        return closest;
    }
}

