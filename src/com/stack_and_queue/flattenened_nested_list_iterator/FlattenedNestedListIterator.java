package com.stack_and_queue.flattenened_nested_list_iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FlattenedNestedListIterator implements Iterator<Integer> {
    List<Integer> flattenedList; // A list of integers, flattened from the nested list
    Iterator<Integer> iterator; // An iterator for the flattened list

    public FlattenedNestedListIterator(List<NestedInteger> nestedList) {
        flattenedList = new ArrayList<>();
        getFlattenedList(flattenedList, nestedList); // Flatten the nested list and populate flattenedList
        iterator = flattenedList.iterator(); // Get an iterator for the flattened list
    }

    @Override
    public Integer next() {
        return iterator.next(); // Get the next integer from the flattened list
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext(); // Check if there are more integers in the flattened list
    }

    private void getFlattenedList(List<Integer> flattenedList, List<NestedInteger> nestedList) {
        for (NestedInteger nestedInteger : nestedList) { // Iterate through the nested integers
            if (nestedInteger.isInteger()) { // If the nested integer is an integer, add it to the flattened list
                flattenedList.add(nestedInteger.getInteger());
            } else { // If the nested integer is a list, recursively flatten it
                getFlattenedList(flattenedList, nestedInteger.getList());
            }
        }
    }


    // This is the interface that allows for creating nested lists.
    // You should not implement it, or speculate about its implementation
    private interface NestedInteger {

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return empty list if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
    }
}

