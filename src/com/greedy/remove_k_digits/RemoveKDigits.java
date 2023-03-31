package com.greedy.remove_k_digits;

import java.util.ArrayDeque;
import java.util.Deque;

public class RemoveKDigits {
    public String removeKDigits(String num, int k) {
        // Create a deque to store the digits of the number
        Deque<Character> deque = new ArrayDeque<>();

        // Iterate through the characters of the number
        for (char c : num.toCharArray()) {
            // Remove the digits from the top of the deque until we find a smaller digit or k becomes 0
            while (!deque.isEmpty() && k > 0 && deque.peek() > c) {
                deque.pop();
                k--;
            }

            // If the deque is not empty or the current character is not '0', add the character to the deque
            // We skip '0' as we cannot have leading zeroes in the resulting number
            if (!deque.isEmpty() || c != '0') {
                deque.push(c);
            }
        }

        // If k is still greater than zero, remove k digits from the end of the deque
        while (!deque.isEmpty() && k-- > 0) {
            deque.pop();
        }

        // If the deque is empty, return "0"
        if (deque.isEmpty()) return "0";

        // Build a string from the digits in the deque and return it as the result
        StringBuilder builder = new StringBuilder();
        while (!deque.isEmpty()) {
            builder.append(deque.pollLast());
        }
        return builder.toString();
    }
}

