package com.heaps.two_heaps.find_median_from_data_stream;

import java.util.Collections;
import java.util.PriorityQueue;

public class FindMedianFromDataStream {

    private class MedianFinder {
        PriorityQueue<Integer> minHeap; // Create a priority queue to hold smaller numbers
        PriorityQueue<Integer> maxHeap; // Create a priority queue to hold larger numbers

        // Constructor function to initialize the data structure
        public MedianFinder() {
            minHeap = new PriorityQueue<>(); // Initialize the priority queue for smaller numbers
            maxHeap = new PriorityQueue<>(Collections.reverseOrder()); // Initialize the priority queue for larger numbers in reverse order
        }

        // Function to add a new number to the data structure
        public void addNum(int num) {
            minHeap.offer(num); // Add the new number to the priority queue for smaller numbers
            maxHeap.offer(minHeap.poll()); // Take out the smallest number from the priority queue for smaller numbers and add it to the priority queue for larger numbers

            // If the priority queue for larger numbers has more elements
            if (minHeap.size() < maxHeap.size()) {
                minHeap.offer(maxHeap.poll()); // Take out the largest number from the priority queue for larger numbers and add it to the priority queue for smaller numbers
            }
        }

        // Function to find the median of all the numbers in the data structure
        public double findMedian() {
            // If the priority queues for smaller and larger numbers have the same size
            if (minHeap.size() == maxHeap.size()) {
                return (minHeap.peek() + maxHeap.peek()) / 2.0; // Return the average of the smallest number from the priority queue for smaller numbers and the largest number from the priority queue for larger numbers
            } else {
                return minHeap.peek(); // Otherwise, return the smallest number from the priority queue for smaller numbers
            }
        }
    }
}
