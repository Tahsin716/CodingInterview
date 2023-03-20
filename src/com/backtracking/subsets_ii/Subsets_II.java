package com.backtracking.subsets_ii;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets_II {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // Sort the input array to group duplicate elements together
        Arrays.sort(nums);

        // Create a list to store all subsets
        List<List<Integer>> result = new ArrayList<>();

        // Call the backtrack function to generate subsets
        backtrack(result, new ArrayList<>(), 0, nums);

        // Return the list of subsets
        return result;
    }

    // A recursive function to generate subsets
    private void backtrack(List<List<Integer>> result, List<Integer> tempList, int start, int[] nums) {
        // Add the current subset to the list of subsets
        result.add(new ArrayList<>(tempList));

        // Generate subsets by adding one more element each time
        for (int i = start; i < nums.length; i++) {
            // Skip duplicates of the current element
            if (i > start && nums[i] == nums[i - 1]) continue;

            tempList.add(nums[i]);

            // Call the backtrack function recursively to generate subsets
            backtrack(result, tempList, i + 1, nums);

            // Remove the last element to generate the next subset
            tempList.remove(tempList.size() - 1);
        }
    }
}

