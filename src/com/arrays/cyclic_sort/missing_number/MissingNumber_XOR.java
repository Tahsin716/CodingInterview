package com.arrays.cyclic_sort.missing_number;

public class MissingNumber_XOR {
    public int missingNumber(int[] nums) {
        int missingNumber = 0;

        // Use XOR to toggle the bits of numbers in nums array and its index (1-based index)
        // Toggling bits on and off using the index and nums element will lead the bits to be 0
        // but the missing number will have bits on, as we turned them on with index
        // but never turned them off
        for (int i = 0; i < nums.length; i++) {
            missingNumber ^= i + 1;
            missingNumber ^= nums[i];
        }

        return missingNumber;
    }
}
