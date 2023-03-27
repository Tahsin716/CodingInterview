package com.maths.minimum_moves_to_equal_array_elements;

public class MinimumMovesToEqualArrayElements {
    public int minMoves(int[] nums) {
        // Initialize variables to keep track of the result and the minimum value in the array
        int result = 0, min = nums[0];

        // Find the minimum value in the array
        for (int num : nums) {
            min = Math.min(min, num);
        }

        // Calculate the difference between each element and the minimum value and add it to the result
        for (int num : nums) {
            result += num - min;
        }

        // Return the result
        return result;
    }
}

