package com.stackandqueue.stack_using_queue;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueue {
    Queue<Integer> queue = new LinkedList<>();

    public void push(int element) {
        queue.offer(element);
        for (int i = 0; i < queue.size(); i++) {
            queue.offer(queue.poll());
        }
    }

    public int pop() {
        return queue.poll();
    }

    public int top() {
        return queue.peek();
    }

    public int size() {
        return queue.size();
    }
}
