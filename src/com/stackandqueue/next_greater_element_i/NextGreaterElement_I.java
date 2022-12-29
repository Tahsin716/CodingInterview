package com.stackandqueue.next_greater_element_i;

import java.util.HashMap;
import java.util.Stack;

public class NextGreaterElement_I {
    public int[] nextGreaterElement(int[] firstNum, int[] secondNum) {
        HashMap<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();

        for (int i = secondNum.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && secondNum[i] > stack.peek()) stack.pop();

            if (!stack.isEmpty()) map.put(secondNum[i], stack.peek());

            stack.push(secondNum[i]);
        }

        for (int i = 0; i < firstNum.length; i++)
            firstNum[i] = map.getOrDefault(firstNum[i], -1);

        return firstNum;
    }
}
