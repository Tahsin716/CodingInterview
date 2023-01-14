package com.arrays.sliding_window.find_all_anagrams_in_a_string;

import java.util.ArrayList;
import java.util.List;

public class FindAllAnagramsInAString {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int start = 0, end = 0, length = s.length(), characterCount = p.length(), windowSize;
        int[] map = new int[26];

        for (char c : p.toCharArray()) map[c - 'a']++;

        while (end < length) {
            int currentCharacter = s.charAt(end) - 'a';
            // We found a character from 'p' string, so decrement characterCount
            if (map[currentCharacter] > 0) characterCount--;

            // The character is taken in window, so decrement it
            map[currentCharacter]--;
            windowSize = end - start + 1;

            if (windowSize == p.length()) {
                int startCharacter = s.charAt(start) - 'a';
                // characterCount == 0, so we found an anagram, so insert start into result
                if (characterCount == 0) result.add(start);

                // startCharacter was part of the anagram, and shifting start will make the character out of window
                // so increment characterCount
                if (map[startCharacter] >= 0) characterCount++;

                // Character out of window, so increment it
                map[startCharacter]++;
                start++;
            }

            end++;
        }

        return result;
    }
}
