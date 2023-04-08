package com.arrays.sliding_window.longest_substring_with_atleast_k_repeating_characters;

public class LongestSubstringWithAtLeastKRepeatingCharacters {
    public int longestSubstring(String s, int k) {
        // base case: if the string is null or empty, return 0
        if (s == null || s.length() == 0) return 0;

        // create a frequency map to count the occurrence of each character in the string
        char[] frequencyMap = new char[26];

        for (int i = 0; i < s.length(); i++) {
            frequencyMap[s.charAt(i) - 'a']++;
        }

        // check if all characters in the string have frequency >= k
        boolean isAllCharactersMoreThanK = true;

        for (char c : frequencyMap) {
            // If we find any character which appears less than K times in string.
            if (c < k && c > 0) {
                isAllCharactersMoreThanK = false;
                break;
            }
        }

        // if all characters in the string have frequency >= k, then the whole string is a valid substring
        if (isAllCharactersMoreThanK){
            return s.length();
        }

        int result = 0, start = 0, end = 0;

        // Use Two-pointer to traverse the characters in the string
        while (end < s.length()) {
            // recursively call the function on the substrings that do not meet the k frequency condition
            if (frequencyMap[s.charAt(end) - 'a'] < k) {
                // Split the string and recurse over the left part from start till current
                // and keep the maximum count
                result = Math.max(result, longestSubstring(s.substring(start, end), k));
                // set start = end + 1 and now process the right substring
                start = end + 1;
            }
            // keep incrementing the right pointer.
            end++;
        }

        // check the last remaining substring
        result = Math.max(result, longestSubstring(s.substring(start), k));

        return result;
    }
}
