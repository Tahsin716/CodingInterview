package com.maths.pow_x_n;

public class Pow_X_N {
    public double myPow(double x, int n) {
        // If n is zero, the result is always 1
        if (n == 0)
            return 1;

        // If n is negative, we calculate the reciprocal of x raised to the power -(n+1)
        // This is done to handle the case where n is Integer.MIN_VALUE
        if (n < 0){
            return 1 / x * myPow(1 / x, -(n + 1));
        }

        // If n is positive, we recursively calculate the power of x
        return (n % 2 == 0) ? myPow(x * x, n / 2) : x * myPow(x * x, n / 2);
    }
}

