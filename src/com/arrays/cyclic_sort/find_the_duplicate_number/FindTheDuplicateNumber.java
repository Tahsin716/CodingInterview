package com.arrays.cyclic_sort.find_the_duplicate_number;

public class FindTheDuplicateNumber {
    public int findDuplicate(int[] nums) {
        // Fast and Slow Pointer
        int slow = nums[0];
        int fast = nums[0];

        // Perform a fast and slow pointer technique with a do-while loop to check whether a loop exists
        // in the array
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        int cycleStart = nums[0];

        // Perform fast and slow pointer technique with, a while-loop to find the start of the loop
        // that is the duplicate number
        while (cycleStart != slow) {
            cycleStart = nums[cycleStart];
            slow = nums[slow];
        }

        return cycleStart;
    }
}
