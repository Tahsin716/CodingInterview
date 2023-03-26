package com.strings.longest_palindromic_substring;

public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }

        int start = 0;
        int end = 0;

        for (int i = 0; i < s.length(); i++) {
            // Find the length of the longest palindrome with the current character as its center
            int len1 = expandAroundCenter(s, i, i);
            // Find the length of the longest palindrome with the current character and its neighbor as center
            int len2 = expandAroundCenter(s, i, i + 1);
            // Take the max length palindrome from both the cases
            int len = Math.max(len1, len2);
            // If the length of the current palindrome is greater than the longest palindrome found so far
            if (len > end - start) {
                // Update the starting and ending indices of the longest palindrome found so far
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        // Return the longest palindrome substring
        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        // Find the length of the palindrome with the given center(s)
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}

