package com.binarysearch.minimum_limit_of_balls_in_a_bag;

import java.util.Arrays;

public class MinimumLimitOfBallsInABag {
    public int minimumSize(int[] nums, int maxOperations) {
        // Initialize start to 1 and ans to -1
        int start = 1, ans = -1;
        // Set end to the maximum number of balls in a bag
        int end = Arrays.stream(nums).max().getAsInt();

        // Binary search
        while (start <= end) {
            // Find the middle value of start and end
            int mid = start + (end - start) / 2;

            // Check if the current penalty is valid
            if (isValidOperation(mid, maxOperations, nums)) {
                // If it is, update the answer and decrease the penalty
                ans = mid;
                end = mid - 1;
            } else {
                // If it is not, increase the penalty
                start = mid + 1;
            }
        }

        // Return the minimum possible penalty
        return ans;
    }

    // Check if it is possible to divide the bags into smaller bags such that the maximum number of balls in a bag is less than or equal to the given penalty
    private boolean isValidOperation(int penalty, int maxOperations, int[] nums) {
        // Initialize totalOperations to 0
        int totalOperations = 0, numOfOperation;

        // Iterate over each bag
        for (int num : nums) {
            // Calculate the number of operations required to divide the bag
            numOfOperation = num / penalty;

            // If the bag is divisible by penalty, decrease the number of operations required by 1
            // If the bag is already the size of penalty, we don't need to perform any more operation
            // that is why we decrement 1, when bag is divisible by penalty
            if (num % penalty == 0) numOfOperation--;

            // Add the number of operations required to totalOperations
            totalOperations += numOfOperation;
        }

        // Return true if the total number of operations required is less than or equal to maxOperations, else return false
        return totalOperations <= maxOperations;
    }
}

