package com.dynamic_programming.fibonacci_number;

public class FibonacciNumber {
    public int fib(int n) {
        int[] fibNum = new int[2];
        fibNum[0] = 0;
        fibNum[1] = 1;

        // Base case
        if (n <= 1)
            return fibNum[n];

        // Fib[n] = Fib[n - 1] + Fib[n - 2]
        for (int i = 2; i <= n; i++) {
            // Store Fib[1] in a temp variable
            int temp = fibNum[1];
            // Fib[1] = Fib[1] + Fib[0], i.e update Fib[1] = Fib[n]
            fibNum[1] += fibNum[0];
            // Assign Fib[0] = Fib[1], i.e update Fib[0] = Fib[n - 1]
            fibNum[0] = temp;
        }

        // Fib[1] == Fib[n], so return it
        return fibNum[1];
    }
}
