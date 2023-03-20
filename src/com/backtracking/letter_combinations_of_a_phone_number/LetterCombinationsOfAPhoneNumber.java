package com.backtracking.letter_combinations_of_a_phone_number;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber {
    public List<String> letterCombinations(String digits) {
        // Store the mapping of letters for each digit as an array of strings
        String[] letters = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> result = new ArrayList<>();

        // If the input string is empty, return an empty list
        if (digits == null || digits.length() == 0) {
            return result;
        }

        // Call the backtrack function to generate all possible combinations
        backtrack(0, result, new StringBuilder(), letters, digits);

        // Return the final result
        return result;
    }

    private void backtrack(int index, List<String> result, StringBuilder stringBuilder, String[] letters, String digits) {
        // If we have generated all digits, add the current combination to the result
        if (index == digits.length()) {
            result.add(stringBuilder.toString());
            return;
        }

        // Get the letters that the current digit can represent
        int letterIndex = digits.charAt(index) - '0';
        String letter = letters[letterIndex];

        // Generate all possible combinations for the current digit
        for (int i = 0; i < letter.length(); i++) {
            // Add the current letter to the combination
            stringBuilder.append(letter.charAt(i));

            // Recursively call the backtrack function for the next digit
            backtrack(index + 1, result, stringBuilder, letters, digits);

            // Remove the last letter from the combination to try the next one
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
    }
}

