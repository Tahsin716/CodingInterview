package com.arrays.sliding_window.minimum_window_substring;

import java.util.HashMap;

public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        int start = 0, end = 0, windowSize = Integer.MAX_VALUE, windowStart = 0, count = t.length();

        // character count in map for string t
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        while (end < s.length()) {
            char c = s.charAt(end);

            // current character exists in map
            if (map.containsKey(c)) {
                // We found a character from 't' string, so decrement count
                if (map.get(c) > 0) count--;
                // character is in window, so decrement it in map
                map.put(c, map.get(c) - 1);
            }

            // While window is valid, count == 0 (all characters in string 't' are in the window)
            // We need to reduce the window size, to find minimum window substring
            while (count == 0) {
                int currentWindowSize = end - start + 1;

                // Find the max windowSize and windowStart for it
                if (currentWindowSize < windowSize) {
                    windowSize = currentWindowSize;
                    windowStart = start;
                }

                char startCharacter = s.charAt(start);

                if (map.containsKey(startCharacter)) {
                    // Increment startCharacter in map as shifting left will discard it from window
                    map.put(startCharacter, map.get(startCharacter) + 1);

                    // startCharacter was a character from string 't' and it was discarded from window
                    // so increment count
                    if (map.get(startCharacter) > 0) count++;
                }

                start++;
            }

            end++;
        }

        return windowSize == Integer.MAX_VALUE ? "" : s.substring(windowStart, windowStart + windowSize);
    }
}
