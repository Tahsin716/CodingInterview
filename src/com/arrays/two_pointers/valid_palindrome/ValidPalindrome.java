package com.arrays.two_pointers.valid_palindrome;

public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        // Convert string to lowercase letters only
        char[] string = s.toLowerCase().toCharArray();

        int start = 0, end = string.length - 1;

        while (start < end) {
            // While the startCharacter is not a letter/digit move start forward
            while (start < end && !isChar(string[start]))
                start++;

            // While the endCharacter is not a letter/digit move end backward
            while (start < end && !isChar(string[end]))
                end--;

            // If the start and end character don't match, then not a palindrome
            if (string[start] != string[end])
                return false;

            start++;
            end--;
        }

        return true;
    }

    private boolean isChar(char c) {
        return Character.isLetterOrDigit(c);
    }
}
