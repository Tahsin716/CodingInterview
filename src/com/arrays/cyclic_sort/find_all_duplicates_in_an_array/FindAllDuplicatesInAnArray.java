package com.arrays.cyclic_sort.find_all_duplicates_in_an_array;

import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicatesInAnArray {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> duplicates = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            // Take the absolute value of nums[i] in case it has been inverted to negative
            // and turn it to 0th based index
            int index = Math.abs(nums[i]) - 1;

            // nums[index] has been inverted to negative, so number 'index' already exists
            // in nums array, so insert it into duplicates array
            // turn it from 0th to 1 based index
            if (nums[index] < 0) {
                duplicates.add(index + 1);
            } else {
                // Invert nums[index] as negative, to mark that index exists in array
                nums[index] = -nums[index];
            }
        }

        return duplicates;
    }
}
