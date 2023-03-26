package com.arrays.basic_array.next_permutation;

import java.util.Arrays;

public class NextPermutation {
    public void nextPermutation(int[] nums) {
        // Find the index of the first element from the right that is smaller than the element to its right
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) i--;

        // If such an element exists
        if (i >= 0) {
            // Find the index of the smallest element from the right that is greater than the first element
            int j = nums.length - 1;
            while (j >= 0 && nums[i] >= nums[j]) j--;

            // Swap the two elements
            swap(nums, i, j);
        }

        // Reverse the order of the elements to the right of the first element
        Arrays.sort(nums, i + 1, nums.length);
    }

    // Define a method for swapping two elements
    private void swap(int[] nums, int i , int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
