package com.maths.happy_number;

import java.util.HashSet;

public class HappyNumber {
    public boolean isHappy(int n) {
        // Create a HashSet to keep track of seen numbers
        HashSet<Integer> set = new HashSet<>();

        // Loop until n is either 1 or a number that has been seen before
        while (n != 1 && !set.contains(n)) {
            // Add the current number to the set of seen numbers
            set.add(n);
            // Get the sum of squares of the digits of the current number
            n = getDigitSum(n);
        }

        // If n is 1, the number is happy; otherwise, it is not
        return n == 1;
    }

    // Helper method to get the sum of squares of the digits of a number
    private int getDigitSum(int num) {
        int sum = 0;

        // Loop through each digit of the number and add its square to the sum
        while (num > 0) {
            int digit = num % 10;
            sum += digit * digit;
            num /= 10;
        }

        return sum;
    }
}
