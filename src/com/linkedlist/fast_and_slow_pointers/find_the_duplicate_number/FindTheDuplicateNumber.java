package com.linkedlist.fast_and_slow_pointers.find_the_duplicate_number;

public class FindTheDuplicateNumber {
    public int findDuplicate(int[] nums) {
        // We will perform fast & slow pointer technique to find
        // cycle in the array as we do in linked list
        // assign slow and fast to as nums[0]
        int slow = nums[0];
        int fast = nums[0];

        // Perform do-while loop to do a fast and slow pointer traversal of the array
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        // Find the start of the cycle, that is the duplicate number
        int cycleStart = nums[0];

        // Perform a 'while' loop to find the start of the cycle
        while (cycleStart != slow) {
            cycleStart = nums[cycleStart];
            slow = nums[slow];
        }

        return cycleStart;
    }
}
