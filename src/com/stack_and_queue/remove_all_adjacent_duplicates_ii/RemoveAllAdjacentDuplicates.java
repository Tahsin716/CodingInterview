package com.stack_and_queue.remove_all_adjacent_duplicates_ii;

public class RemoveAllAdjacentDuplicates {
    public String removeDuplicates(String s, int k) {
        // Initialize a StringBuilder object to build the result string
        StringBuilder stringBuilder = new StringBuilder();
        // Initialize an integer array to store the count of adjacent duplicates for each character
        int[] count = new int[s.length()];
        // Initialize variables to store the previous index and length of the StringBuilder object
        int currentIndex, length;

        // Loop through each character in the input string s
        for (char c : s.toCharArray()) {
            // Append the character to the StringBuilder object
            stringBuilder.append(c);
            // Get the length of the StringBuilder object
            length = stringBuilder.length();
            // Get the previous index of the StringBuilder object
            currentIndex = stringBuilder.length() - 1;

            // Calculate the count of adjacent duplicates for the current character
            count[currentIndex] = 1 +
                    (currentIndex > 0 && stringBuilder.charAt(currentIndex) == stringBuilder.charAt(currentIndex - 1)
                            ? count[currentIndex - 1]
                            : 0);

            // If the count of adjacent duplicates for the current character is k, delete the last k characters from the StringBuilder object
            if (count[currentIndex] == k) stringBuilder.delete(length - k, length);
        }

        // Return the final result string
        return stringBuilder.toString();
    }
}

