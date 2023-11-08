package com.arrays.cyclic_sort.find_all_numbers_disappeared_in_an_array;

import java.util.ArrayList;
import java.util.List;

public class FindAllNumbersDisappearedInArray {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        List<Integer> ans = new ArrayList<>();

        // Similar to First Missing Positive question
        // Invert the nums[index] as negative to mark that number index exists
        for (int i = 0; i < n; i++) {
            int index = Math.abs(nums[i]) - 1;

            if (nums[index] > 0) nums[index] = -nums[index];
        }

        for (int i = 0; i < n; i++) {
            // If the nums[i] is between the range 1...n
            // then that means 'i' does not exist in the array as it is not marked negative
            // insert 'i + 1' (0th to 1-based index)
            if (nums[i] > 0 && nums[i] <= n) ans.add(i + 1);
        }

        return ans;
    }
}
