package com.arrays.two_pointers.remove_duplicates_from_sorted_array;

public class RemoveDuplicatesFromSortedArray {

    // What the question basically wants is, for us to sort the unique numbers
    // to the front of the array
    public int removeDuplicates(int[] nums) {
        // There will be one number always in the array, so there is always at least
        // one unique number, so count starts from 1
        int count = 1, lastUniqueNumberIndex = 0;

        for (int i = 0; i < nums.length; i++) {
            // current number is unique, as numbers are in non-decreasing order, and it is not
            // same as previous unique number, so increment index and place current number there
            // and increment count as we found a unique number
            if (nums[i] > nums[lastUniqueNumberIndex]) {
                nums[++lastUniqueNumberIndex] = nums[i];
                count++;
            }
        }

        return count;
    }
}
