package com.stackandqueue.stock_span;

import java.util.Stack;

public class StockSpan {
    private int currentIndex;
    private Stack<PriceAndIndex> stack;

    public StockSpan() {
        stack = new Stack<>();
        currentIndex = -1;
    }

    public int next(int price) {
        currentIndex += 1;

        // Monotonic stack, stock prices lower than current price are not necessary so remove them
        while (!stack.isEmpty() && stack.peek().price <= price)
            stack.pop();

        if (stack.isEmpty()) {
            stack.push(new PriceAndIndex(currentIndex, price));
            return currentIndex + 1;
        }

        int maxPreviousElementIndex = stack.peek().index;
        stack.push(new PriceAndIndex(currentIndex, price));

        return currentIndex - maxPreviousElementIndex;
    }

    private class PriceAndIndex {
        int price;
        int index;

        public PriceAndIndex(int _index, int _price) {
            index = _index;
            price = _price;
        }
    }
}
