package com.arrays.sliding_window.longest_repeating_character_replacement;

public class LongestCharacterReplacement {
    public int characterReplacement(String s, int k) {
        int start = 0, end = 0, windowSize, numberOfLettersToReplace, mostFrequentCharacterCount = 0, maxLength = 0;
        int[] map = new int[26];

        while (end < s.length()) {
            int currentCharacter = s.charAt(end) - 'A';
            // Character is in the window so increment it
            map[currentCharacter]++;

            mostFrequentCharacterCount = Math.max(mostFrequentCharacterCount, map[currentCharacter]);
            windowSize = end - start + 1;
            numberOfLettersToReplace = windowSize - mostFrequentCharacterCount;

            if (numberOfLettersToReplace > k) {
                int startCharacter = s.charAt(start) - 'A';
                map[startCharacter]--;
                start++;
            }

            windowSize = end - start + 1;
            maxLength = Math.max(maxLength, windowSize);

            end++;
        }

        return maxLength;
    }
}
