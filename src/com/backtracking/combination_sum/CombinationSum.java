package com.backtracking.combination_sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // Sort the array in ascending order
        Arrays.sort(candidates);

        // Initialize the result list as an empty ArrayList
        List<List<Integer>> result = new ArrayList<>();

        // Call the backtrack method with empty tempList and start index as 0
        backtrack(0, target, result, new ArrayList(), candidates);

        // Return the result list
        return result;
    }

    // Private helper method that implements the backtracking algorithm
    private void backtrack(int start, int target,List<List<Integer>> result, List<Integer> tempList, int[] candidates) {
        // If target is less than 0, return
        if (target < 0) return;

        // If target is 0, add tempList to the result list and return
        if (target == 0) {
            result.add(new ArrayList(tempList));
            return;
        }

        // Loop through the candidates array starting at the specified start index
        // and add each candidate to tempList, call the backtrack method recursively with the
        // updated target and start index, and then remove the last candidate from tempList
        // before moving on to the next candidate.
        for (int i = start; i < candidates.length && candidates[i] <= target; i++) {
            tempList.add(candidates[i]);
            backtrack(i, target - candidates[i],result, tempList, candidates);
            tempList.remove(tempList.size() - 1);
        }
    }
}

