package com.arrays.cyclic_sort.set_mismatch;

public class SetMismatch {
    public int[] findErrorNums(int[] nums) {
        // Keep the count of every number in nums array from 1...n
        // Since it's 1-based index that's why length is nums.length + 1
        int[] count = new int[nums.length + 1];
        int[] result = new int[2];

        // Iterate nums and keep track of the frequency of each number
        for (int i = 0; i < nums.length; i++) {
            count[nums[i]]++;
        }

        // Iterate counts array, from 1...n (1-based index)
        // and find the numbers which appeared twice and not even once
        for (int i = 1; i < count.length; i++) {
            if (count[i] == 2) {
                result[0] = i;
            }

            if (count[i] == 0) {
                result[1] = i;
            }
        }

        return result;
    }
}
