package com.arrays.two_pointers.move_zeroes;

public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int zeroIndex = 0;

        for (int i = 0; i < nums.length; i++) {

            // If the current number is not a 0
            // swap the number with the zeroIndex number
            // and increment the zeroIndex
            if (nums[i] != 0) {
                swap(nums, i, zeroIndex);
                zeroIndex++;
            }
        }
    }

    private void swap(int[] nums, int index, int zeroIndex) {
        int temp = nums[zeroIndex];
        nums[zeroIndex] = nums[index];
        nums[index] = temp;
    }
}
