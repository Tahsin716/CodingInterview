package com.backtracking.combination_sum_ii;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum_II {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // Sort the input array to group duplicate elements together
        Arrays.sort(candidates);

        // Initialize the result list as an empty ArrayList
        List<List<Integer>> result = new ArrayList<>();

        // Call the backtrack method with index 0, target, empty tempList and sorted candidates array
        backtrack(0, target, result, new ArrayList<>(), candidates);

        // Return the result list
        return result;
    }

    // Private helper method that implements the backtracking algorithm
    private void backtrack(int index, int target, List<List<Integer>> result, List<Integer> tempList, int[] candidates) {
        // If target is less than 0, return
        if (target < 0) return;

        // If target is 0, add tempList to the result list and return
        if (target == 0) {
            result.add(new ArrayList<>(tempList));
            return;
        }

        // Loop through the candidates array starting at the specified index
        // and add each candidate to tempList, call the backtrack method recursively with the
        // updated target and index, and then remove the last candidate from tempList
        // before moving on to the next candidate.
        for (int i = index; i < candidates.length && candidates[i] <= target; i++) {
            // If the current candidate is the same as the previous candidate
            // the loop skips to the next iteration, to avoid duplicates
            if (i > index && candidates[i - 1] == candidates[i]) continue;

            tempList.add(candidates[i]);
            backtrack(i + 1, target - candidates[i], result, tempList, candidates);
            tempList.remove(tempList.size() - 1);
        }
    }
}

