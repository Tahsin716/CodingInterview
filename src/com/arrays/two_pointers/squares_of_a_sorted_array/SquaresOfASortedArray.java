package com.arrays.two_pointers.squares_of_a_sorted_array;

public class SquaresOfASortedArray {
    public int[] sortedSquares(int[] nums) {
        int[] sorted = new int[nums.length];
        int start = 0, end = nums.length - 1, currentPosition = nums.length - 1;

        while (start <= end) {

            // square of -10 is greater than square of 4,
            // so we will check if the abs(nums[start]) > abs(nums[end])
            // and insert the numbers from the back of the array
            // i.e. back -> front or largest square to the smallest square number
            if (Math.abs(nums[start]) > Math.abs(nums[end])) {
                sorted[currentPosition] = nums[start] * nums[start];
                start++;
            } else {
                sorted[currentPosition] = nums[end] * nums[end];
                end--;
            }

            currentPosition--;
        }

        return sorted;
    }
}
