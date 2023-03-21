package com.arrays.basic_array.majority_element;

public class MajorityElement {
    // Boyre Moore Voting Algorithm
    public int majorityElement(int[] nums) {
        // variable candidate is used to store the current majority element
        // and count is used to store the occurrence of the current majority element
        int count = 0, candidate = -1;

        for (int num : nums) {
            // If count equals zero, change candidate to current num
            if (count == 0)
                candidate = num;

            // If current num equals candidate then, increment count otherwise decrement
            count += (num == candidate) ? 1 : - 1;
        }

        return candidate;
    }
}
