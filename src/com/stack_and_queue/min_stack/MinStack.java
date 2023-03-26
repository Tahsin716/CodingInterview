package com.stack_and_queue.min_stack;

import com.common.datastructure.Pair;

import java.util.Stack;

public class MinStack {
    Stack<Pair<Integer, Integer>> stack;

    public MinStack() {
        stack = new Stack<>();
    }

    public void push(int val) {
        if (stack.isEmpty()) {
            stack.push(new Pair(val, val));
        } else {
            stack.push(new Pair(val, Math.min(val, stack.peek().getValue())));
        }
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek().getKey();
    }

    public int getMin() {
        return stack.peek().getValue();
    }

}


