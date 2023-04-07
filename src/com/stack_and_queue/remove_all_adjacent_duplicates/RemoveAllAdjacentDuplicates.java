package com.stack_and_queue.remove_all_adjacent_duplicates;

public class RemoveAllAdjacentDuplicates {
    public String removeDuplicates(String s) {
        // Create a StringBuilder to store the non-duplicate characters
        StringBuilder stringBuilder = new StringBuilder();

        // Iterate over the characters in the input string
        for (char c : s.toCharArray()) {
            // Get the current length of the StringBuilder
            int len = stringBuilder.length();

            // Check if the current character is the same as the last character in the StringBuilder
            if (len > 0 && stringBuilder.charAt(len - 1) == c) {
                // If it is, remove the last character from the StringBuilder
                stringBuilder.deleteCharAt(len - 1);
            } else {
                // If it is not, add the character to the StringBuilder
                stringBuilder.append(c);
            }
        }

        // Return the non-duplicate characters as a string
        return stringBuilder.toString();
    }
}

