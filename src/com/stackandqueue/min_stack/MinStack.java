package com.stackandqueue.min_stack;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Stack;

public class MinStack {
    Stack<Pair> stack;

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

@Getter
@AllArgsConstructor
class Pair {
    private int key;
    private int value;
}
