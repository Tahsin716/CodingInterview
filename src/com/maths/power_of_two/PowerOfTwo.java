package com.maths.power_of_two;

public class PowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        // If n is less than or equal to 0, it cannot be a power of 2
        if (n <= 0) return false;

        // Divide n by 2 repeatedly until it is no longer divisible by 2
        while (n % 2 == 0) n /= 2;

        // If n is 1 at the end of the process, it is a power of 2
        return n == 1;
    }
}

