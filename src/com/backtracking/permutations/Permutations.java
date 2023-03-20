package com.backtracking.permutations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        // Create an empty result list
        List<List<Integer>> result = new ArrayList<>();

        // Sort the input array in ascending order
        Arrays.sort(nums);

        // Call the backtrack function to generate all permutations
        backtrack(result, new ArrayList<>(), new boolean[nums.length], nums);

        // Return the result
        return result;
    }

    // The backtrack function to generate all permutations
    private void backtrack(List<List<Integer>> result, List<Integer> tempList, boolean[] visited, int[] nums) {
        // If tempList has the same length as nums, a new permutation is found
        if (tempList.size() == nums.length) {
            result.add(new ArrayList<>(tempList));
            return;
        }

        // Iterate through all possible candidates
        for (int i = 0; i < nums.length; i++) {
            // If the candidate has been visited, skip it
            if (visited[i]) continue;

            // Mark the candidate as visited and add it to the tempList
            visited[i] = true;
            tempList.add(nums[i]);

            // Recursively call the backtrack function with the updated tempList and visited array
            backtrack(result, tempList, visited, nums);

            // Mark the candidate as unvisited and remove it from the tempList
            visited[i] = false;
            tempList.remove(tempList.size() - 1);
        }
    }
}

