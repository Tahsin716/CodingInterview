package com.heaps.top_k_elements.find_k_closest_elements;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FindKClosestElements_TwoPointer {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int start = 0, end = arr.length - 1;

        // A modified two pointer technique, we need a window of size k
        // so end - start >= k
        while (end - start >= k) {
            // We check which of the pointer start/end is closest to x
            // since the numbers are sorted in ascending order
            // we don't really need absolute value,
            // if x - arr[start] <= arr[end] - x, we decrement end, because either
            // x- arr[start] is closer to x, or if it is equal than we need to sort them in a < b
            // since array is already sorted, so arr[start] < arr[end], thus end is decremented
            if (x - arr[start] <= arr[end] - x) {
                end--;
            } else {
                start++;
            }
        }

        return Arrays.stream(arr, start, start + k).boxed().collect(Collectors.toList());
    }
}
