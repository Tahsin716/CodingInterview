package com.strings.longest_common_prefix;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        // If there are no strings in the array, return an empty string
        if (strs.length == 0) return "";

        // Create a StringBuilder to store the common prefix
        StringBuilder stringBuilder = new StringBuilder();

        // Keep track of the index of the character being considered
        int index = 0;

        // Iterate through the characters in the first string in the array
        for (char c : strs[0].toCharArray()) {
            // For each character, compare it with the corresponding character in each of the other strings
            for (int i = 1; i < strs.length; i++) {
                // If the index is out of bounds or the character is not equal to the current character, return the current common prefix
                if (index >= strs[i].length() || strs[i].charAt(index) != c) return stringBuilder.toString();
            }

            // If the character is equal to the corresponding character in all strings, add it to the common prefix and move on to the next character
            stringBuilder.append(c);
            index++;
        }

        // If the loop completes, it means the entire first string is the common prefix
        return stringBuilder.toString();
    }
}

