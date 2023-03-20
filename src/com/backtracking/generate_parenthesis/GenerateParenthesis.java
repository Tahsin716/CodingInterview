package com.backtracking.generate_parenthesis;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        // Create a list to store the valid combinations.
        List<String> result = new ArrayList<>();

        // Call the backtrack method with initial parameters.
        backtrack(n, 0, 0, result, new StringBuilder());

        // Return the list of valid combinations.
        return result;
    }

    private void backtrack(int n, int open, int close, List<String> result, StringBuilder stringBuilder) {
        // If we have used n pairs of parentheses, then we have a valid combination.
        // Add the valid combination to the result list.
        if (open == n && close == n) {
            result.add(stringBuilder.toString());
            return;
        }

        // If we haven't used all the opening parentheses yet, we can add one.
        if (open < n) {
            stringBuilder.append("("); // Add an opening parenthesis to the current string.
            backtrack(n, open + 1, close, result, stringBuilder); // Recursively call backtrack method with updated parameters.
            stringBuilder.deleteCharAt(stringBuilder.length() - 1); // Remove the last character (opening parenthesis) from the current string.
        }

        // If we have used at least one opening parenthesis and haven't used all the closing parentheses yet, we can add one.
        if (close < open) {
            stringBuilder.append(")"); // Add a closing parenthesis to the current string.
            backtrack(n, open, close + 1, result, stringBuilder); // Recursively call backtrack method with updated parameters.
            stringBuilder.deleteCharAt(stringBuilder.length() - 1); // Remove the last character (closing parenthesis) from the current string.
        }
    }
}

