package com.heaps.top_k_elements.find_k_closest_elements;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FindKClosestElements_BinarySearch {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        // We need to compare between arr[mid] and arr[mid +k] to check
        // whether x is closer to arr[mid] or arr[mid +k], so end = arr.length - k
        int start = 0, end = arr.length - k, mid;

        while (start < end) {
            mid = start + (end - start) / 2;

            // We will binary search to find the whether arr[mid] or arr[mid + k] is closer to x
            // if x - arr[mid] <= arr[mid + k] - x, that means arr[mid] is closer, so we can discard
            // arr[mid + 1], arr[mid + 2]...arr[mid + k], by setting end = mid,
            // else arr[mid + k] is closer so, we set start = mid + 1 to discard arr[start]...arr[mid]
            if (x - arr[mid] <= arr[mid + k] - x) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        return Arrays.stream(arr, start, start + k).boxed().collect(Collectors.toList());
    }
}
