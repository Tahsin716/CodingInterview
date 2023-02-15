package com.stack_and_queue.next_smaller_element;

import java.util.Stack;

public class NextSmallerElement {
    public int[] prevSmaller(int[] A) {
        Stack<Integer> stack = new Stack<>();
        int[] G = new int[A.length];

        for (int i = 0; i < A.length; i++) {
            while (!stack.isEmpty() && stack.peek() <= A[i]) stack.pop();

            G[i] = !stack.isEmpty() ? stack.peek() : -1;

            stack.push(A[i]);
        }

        return G;
    }
}
