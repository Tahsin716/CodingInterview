package com.maths.palindrome_number;

public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        // Return false if x is negative or if x is non-zero and ends with 0
        if (x < 0 || (x != 0 && x % 10 == 0))  return false;

        int reverseNum = 0, currentDigit = 0;

        // Reverse the second half of the number and compare it to the first half
        while (x > reverseNum) {
            // Get the last digit of x and add it to the reverseNum
            currentDigit = x % 10;
            reverseNum = reverseNum * 10  + currentDigit;
            // Remove the last digit from x
            x /= 10;
        }

        // If x is odd, ignore the middle digit when comparing x and reverseNum
        return x == reverseNum || x == reverseNum / 10;
    }
}

