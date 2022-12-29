package com.stackandqueue.queue_using_stack;

import java.util.Stack;

public class QueueUsingStack {
    private Stack<Integer> input;
    private Stack<Integer> output;

    public QueueUsingStack() {
        input = new Stack<>();
        output = new Stack<>();
    }

    public void add(int element) {
        input.push(element);
    }

    public int poll() {
        if (!output.isEmpty()) return output.pop();

        while (!input.isEmpty()) {
            output.push(input.pop());
        }

        return output.pop();
    }

    public int peek() {
        return output.isEmpty() ? input.peek() : output.peek();
    }
}
