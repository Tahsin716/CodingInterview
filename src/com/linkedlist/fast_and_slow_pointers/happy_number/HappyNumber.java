package com.linkedlist.fast_and_slow_pointers.happy_number;

public class HappyNumber {
    public boolean isHappy(int n) {
        // This can be classified as a cycle-detection problem,
        // so basically if we find a repeating digit sum that means there is a cycle
        int slow = n, fast = n;

        // Perform a do-while loop to do a fast and slow pointer traversal of the number
        // to find the digit sum,
        do {
            slow = getDigitSum(slow);
            fast = getDigitSum(getDigitSum(fast));
        } while (slow != fast);

        // check if the number is 1, if yes then it's a happy number else no
        return slow == 1;
    }

    private int getDigitSum(int num) {
        int sum = 0;

        while (num > 0) {
            int digit = num % 10;
            sum += digit * digit;
            num /= 10;
        }

        return sum;
    }
}
