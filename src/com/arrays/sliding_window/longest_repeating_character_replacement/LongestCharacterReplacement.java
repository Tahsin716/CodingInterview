package com.arrays.sliding_window.longest_repeating_character_replacement;

public class LongestCharacterReplacement {
  public int characterReplacement(String s, int k) {
    // Initialize pointers and variables
    int start = 0, end = 0, windowSize, numberOfLettersToReplace, mostFrequentCharacterCount = 0, maxLength = 0;
    int[] map = new int[26]; // Assuming uppercase English letters

    // Iterate through the string using the sliding window approach
    while (end < s.length()) {
      // Convert the character to an index in the range [0, 25]
      int currentCharacter = s.charAt(end) - 'A';

      // Increment the count of the current character in the window
      map[currentCharacter]++;

      // Update the count of the most frequent character in the window
      mostFrequentCharacterCount = Math.max(mostFrequentCharacterCount, map[currentCharacter]);

      // Calculate the size of the current window
      windowSize = end - start + 1;

      // Calculate the number of letters that need to be replaced to make all letters in the window the same
      numberOfLettersToReplace = windowSize - mostFrequentCharacterCount;

      // If the number of letters to replace exceeds the allowed limit (k),
      // move the window by incrementing the start pointer and decrementing the count of the start character
      if (numberOfLettersToReplace > k) {
        int startCharacter = s.charAt(start) - 'A';
        map[startCharacter]--;
        start++;
      }

      // Update the window size and the maximum length encountered so far
      windowSize = end - start + 1;
      maxLength = Math.max(maxLength, windowSize);

      // Move the end pointer to expand the window
      end++;
    }

    // Return the maximum length of the substring with character replacement
    return maxLength;
  }
}
