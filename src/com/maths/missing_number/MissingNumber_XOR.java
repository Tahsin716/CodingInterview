package com.maths.missing_number;

public class MissingNumber_XOR {
    public int missingNumber(int[] nums) {
        int missingNumber = 0;

        for (int i = 0; i < nums.length; i++) {
            missingNumber ^= i + 1; // XOR with 1 to n+1
            missingNumber ^= nums[i]; // XOR with array element
        }

        return missingNumber;
    }
}
