package com.strings.valid_palindrome_ii;

public class ValidPalindrome_II {
    public boolean validPalindrome(String s) {
        // Set the start and end pointers.
        int start = 0, end = s.length() - 1;

        // Iterate through the string until start and end pointers meet.
        while (start < end) {
            // If the characters at the current positions are equal, move to next positions.
            if (s.charAt(start) == s.charAt(end)) {
                start++;
                end--;
            } else {
                // If characters are not equal, check if removing either of them makes a valid palindrome.
                return isPalindrome(s, start + 1, end) || isPalindrome(s, start, end - 1);
            }
        }

        // If the string is a valid palindrome, return true.
        return true;
    }

    // This function checks if a given substring is a valid palindrome.
    private boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start++) != s.charAt(end--)) {
                return false;
            }
        }

        return true;
    }
}

