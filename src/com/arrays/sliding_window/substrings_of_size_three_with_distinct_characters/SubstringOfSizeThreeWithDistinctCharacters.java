package com.arrays.sliding_window.substrings_of_size_three_with_distinct_characters;

import java.util.HashMap;

public class SubstringOfSizeThreeWithDistinctCharacters {
    public int countGoodSubstrings(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int start = 0, end = 0, length = s.length(), ans = 0, windowSize;

        while (end < length) {
            char c = s.charAt(end);
            map.put(c, map.getOrDefault(c, 0) + 1);
            windowSize = end - start + 1;

            // We found a valid window
            if (windowSize == 3) {
                // Map size == 3, so map contains three distinct characters, thus increment result
                if (map.size() == 3) ans++;

                char startChar = s.charAt(start);
                map.put(startChar, map.get(startChar) - 1);

                if (map.get(startChar) == 0) map.remove(startChar);

                start++;
            }

            end++;
        }

        return ans;
    }
}
