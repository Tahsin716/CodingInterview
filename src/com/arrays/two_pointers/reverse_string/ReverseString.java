package com.arrays.two_pointers.reverse_string;

public class ReverseString {
    public void reverseString(char[] s) {
        int start = 0, end = s.length - 1;

        // Use two pointers to swap, front and end characters
        while (start < end) {
            swap(s, start, end);
            start++;
            end--;
        }
    }

    private void swap(char[] s, int start, int end) {
        char temp = s[start];
        s[start] = s[end];
        s[end] = temp;
    }
}
