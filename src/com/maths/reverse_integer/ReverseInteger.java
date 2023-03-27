package com.maths.reverse_integer;

public class ReverseInteger {
    public int reverse(int x) {
        // Initialize variables to keep track of previous reverse number, current digit and reverse number
        int previousReverseNum = 0, currentDigit = 0, reverseNum = 0;

        // Continue to reverse digits of x until it becomes zero
        while (x != 0) {
            // Get the last digit of x and add it to reverse number after multiplying by 10
            currentDigit = x % 10;
            reverseNum = reverseNum * 10 + currentDigit;

            // Check if the reverse number overflows the signed 32-bit integer range
            if ((reverseNum - currentDigit) / 10 != previousReverseNum) return 0;

            // Update previous reverse number and divide x by 10 to remove the last digit
            previousReverseNum = reverseNum;
            x /= 10;
        }

        // Return the reversed number
        return reverseNum;
    }
}
