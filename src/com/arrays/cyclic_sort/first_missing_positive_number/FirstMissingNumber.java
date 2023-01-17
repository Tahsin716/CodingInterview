package com.arrays.cyclic_sort.first_missing_positive_number;

public class FirstMissingNumber {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;

        // All numbers which are less than or equal to 0, i.e. 0 or negative
        // or greater than n, we are turning them into 'n + 1'
        // that is, so that we can ignore them as they will not be the answer (the smallest missing positive number)
        for (int i = 0; i < n; i++)
            if (nums[i] <= 0 || nums[i] > n) nums[i] = n + 1;

        for (int i = 0; i < n; i++) {
            // In case the nums[i] has been inverted to negative, so its absolute value is taken
            int index = Math.abs(nums[i]);

            // Check if the number is a valid index, i.e. it is less than or equal to n
            // We are ignoring numbers which are 0 or negative and numbers greater than n
            // we turned them into 'n + 1' previously
            if (index <= n) {
                // Decrement index to turn it into 0th based index
                index--;

                // Negative marking, to determine that the number index exists
                // Let's say i = 2, so we mark nums[2] = -nums[2]
                // So later if we find nums[2] >= 0, that means it wasn't marked negative
                // and, we can conclude that 2 doesn't exist in the nums array
                if (nums[index] > 0) nums[index] = -nums[index];
            }
        }

        for (int i = 0; i < n; i++) {
            // The first cell which isn't negative doesn't appear in the array
            // so return i + 1 (0th based index)
            if (nums[i] >= 0) return i + 1;
        }

        // All the numbers from 0...n exists in the nums array
        // so the smallest missing positive would be, 'n + 1'
        return n + 1;
    }
}
