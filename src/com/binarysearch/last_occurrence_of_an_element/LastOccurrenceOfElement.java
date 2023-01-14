package com.binarysearch.last_occurrence_of_an_element;

public class LastOccurrenceOfElement {
    public int lastOccurrenceOfElement(int arr[], int target) {
        int result = -1, start = 0, end = arr.length - 1, mid;

        while (start <= end) {
            mid = start + (end - start) / 2;

            if (target == arr[mid]) {
                result = mid;

                // We found the index of the target, but we need to find
                // last occurrence, so we look for it in the right half
                start = mid + 1;
            } else if (target < arr[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return result;
    }
}
