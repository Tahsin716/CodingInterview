package com.backtracking.combinations;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        // Create an empty list to hold the temporary combinations
        List<Integer> temp = new ArrayList<>();
        // Create an empty list to hold the final result
        List<List<Integer>> result = new ArrayList<>();

        // Call the backtrack function to generate all combinations
        backtrack(1, n, k, temp, result);

        // Return the final result
        return result;
    }

    private void backtrack(int start, int n, int k, List<Integer> temp, List<List<Integer>> result) {
        // If the temporary combination has reached the desired length, add it to the final result and return
        if (temp.size() == k) {
            result.add(new ArrayList<>(temp));
            return;
        }

        // Calculate the remaining positions to be filled in the combination and the last possible starter for the next element
        int remainingPositions = k - temp.size();
        int lastPossibleStarter = n - remainingPositions + 1;

        // Iterate through all possible starters for the next element in the combination
        for (int i = start; i <= lastPossibleStarter; i++) {
            // Add the next element to the temporary combination
            temp.add(i);
            // Recursively call backtrack function to generate all possible combinations starting from the next position
            backtrack(i + 1, n, k, temp, result);
            // Remove the last element added to the temporary combination to backtrack and try a different element
            temp.remove(temp.size() - 1);
        }
    }
}

