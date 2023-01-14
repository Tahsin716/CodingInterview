package com.arrays.sliding_window.permutations_in_string;

public class PermutationsInString {
    public boolean checkInclusion(String s1, String s2) {
        int start = 0, end = 0, characterCount = s1.length(), windowSize;
        int[] map = new int[26];

        // character frequency fo string s1
        for (char c : s1.toCharArray()) map[c - 'a']++;

        while (end < s2.length()) {
            int currentCharacter = s2.charAt(end) - 'a';
            // currentCharacter is a part of string s1, so decrement characterCount
            if (map[currentCharacter] > 0) characterCount--;

            // character is part of window so decrement its count
            map[currentCharacter]--;
            windowSize = end - start + 1;

            // We found a valid window
            if (windowSize == s1.length()) {
                int startCharacter = s2.charAt(start) - 'a';
                // All characters of string s1 is part of the window
                // we found a permutation of s1 in s2
                if (characterCount == 0) return true;

                // startCharacter was part of s1, so increment characterCount as we discarded it from window
                if (map[startCharacter] >= 0) characterCount++;

                // increment startCharacter as we discarded it from window, by moving start pointer
                map[startCharacter]++;
                start++;
            }

            end++;
        }

        return false;
    }
}
