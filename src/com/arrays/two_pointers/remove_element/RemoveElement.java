package com.arrays.two_pointers.remove_element;

public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int index = 0;

        for (int i = 0; i < nums.length; i++) {
            // current num is not equal to the value that we are supposed to remove
            // assign current num to nums[index], and increment index.
            if (nums[i] != val) {
                nums[index] = nums[i];
                index++;
            }
        }

        return index;
    }
}
