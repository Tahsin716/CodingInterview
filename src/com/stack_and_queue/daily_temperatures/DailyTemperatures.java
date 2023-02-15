package com.stack_and_queue.daily_temperatures;

import java.util.Stack;

public class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] ans = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = temperatures.length - 1; i >= 0; i--) {
            // Monotonic stack
            while (!stack.isEmpty() && temperatures[stack.peek()] <= temperatures[i]) stack.pop();

            ans[i] = !stack.isEmpty() ? stack.peek() - i : 0;

            stack.push(i);
        }

        return ans;
    }
}
