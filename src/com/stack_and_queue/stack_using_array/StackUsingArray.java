package com.stack_and_queue.stack_using_array;

public class StackUsingArray {
    private final int size;
    private final int[] stack;
    private int top;

    public StackUsingArray() {
        this.size = 1000;
        this.stack = new int[size];
        this.top = -1;
    }

    public StackUsingArray(int size) {
        this.size = size;
        this.stack = new int[size];
        this.top = -1;
    }

    public void push(int element) {
        this.stack[++top] = element;
    }

    public int pop() {
        return this.stack[top--];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public int size() {
        return top + 1;
    }
}
