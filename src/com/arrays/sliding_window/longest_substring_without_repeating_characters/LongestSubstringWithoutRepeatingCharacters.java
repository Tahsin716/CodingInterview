package com.arrays.sliding_window.longest_substring_without_repeating_characters;

import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int start = 0, end = 0, longestSubstring = 0;
        int prevIndex, currentWindowSize;
        char currentCharacter;

        while (end < s.length()) {
            currentCharacter = s.charAt(end);

            // currentCharacter exists in map
            if (map.containsKey(currentCharacter)) {
                // Check if the prevIndex of the character exists in between start <= prevIndex <= end
                // If yes then it is a repeating character in the current window, so move start = prevIndex + 1
                // If prevIndex < start, then it is not a repeating character in current window
                prevIndex = map.get(currentCharacter);
                start = Math.max(start, prevIndex + 1);
            }

            currentWindowSize = end - start + 1;
            longestSubstring = Math.max(longestSubstring, currentWindowSize);
            map.put(currentCharacter, end);

            end++;
        }

        return longestSubstring;
    }
}
