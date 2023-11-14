package com.stack_and_queue.stock_span;

import java.util.Stack;

public class StockSpan {
    private int currentIndex; // Variable to keep track of the current index
    private Stack<PriceAndIndex> stack; // Stack to store PriceAndIndex objects

    // Constructor to initialize the stack and currentIndex
    public StockSpan() {
        stack = new Stack<>();
        currentIndex = -1;
    }

    // Method to calculate the span of the stock's price for the current day
    public int next(int price) {
        currentIndex += 1;

        // Monotonic stack: Remove stock prices lower than the current price
        while (!stack.isEmpty() && stack.peek().price <= price)
            stack.pop();

        // If the stack is empty, the current stock price is the highest so far
        if (stack.isEmpty()) {
            stack.push(new PriceAndIndex(currentIndex, price));
            return currentIndex + 1; // Span is the current index plus 1
        }

        // Calculate the span as the difference between the current index and the index of the maximum previous element
        int maxPreviousElementIndex = stack.peek().index;
        stack.push(new PriceAndIndex(currentIndex, price));

        return currentIndex - maxPreviousElementIndex;
    }

    // Inner class to represent a pair of price and index
    private class PriceAndIndex {
        int price;
        int index;

        // Constructor to initialize PriceAndIndex objects
        public PriceAndIndex(int _index, int _price) {
            index = _index;
            price = _price;
        }
    }
}

