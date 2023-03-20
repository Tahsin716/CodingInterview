package com.backtracking.subsets;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        // Create a list to store all subsets
        List<List<Integer>> result = new ArrayList<>();

        // Call the backtrack function to generate subsets
        backtrack(result, new ArrayList<>(), nums, 0);

        // Return the list of subsets
        return result;
    }

    // A recursive function to generate subsets
    private void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] nums, int start) {
        // Add the current subset to the list of subsets
        result.add(new ArrayList<>(tempList));

        // Generate subsets by adding one more element each time
        for (int i = start; i < nums.length; i++) {
            tempList.add(nums[i]);

            // Call the backtrack function recursively to generate subsets
            backtrack(result, tempList, nums, i + 1);

            // Remove the last element to generate the next subset
            tempList.remove(tempList.size() - 1);
        }
    }
}

