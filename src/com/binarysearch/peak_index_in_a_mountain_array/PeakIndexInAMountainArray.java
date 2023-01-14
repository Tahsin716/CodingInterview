package com.binarysearch.peak_index_in_a_mountain_array;

public class PeakIndexInAMountainArray {
    public int peakIndexInMountainArray(int[] arr) {
        int n = arr.length;
        int start = 0, end = n - 1, mid, leftElement, rightElement;

        while (start <= end) {
            mid = start + (end - start) / 2;
            // mid is the first element, so there is no element on left
            leftElement = mid == 0 ? Integer.MIN_VALUE : arr[mid - 1];
            // mid is the last element, so there is no element on right
            rightElement = mid == n - 1 ? Integer.MIN_VALUE : arr[mid + 1];

            // mid is greater than element on it's right and left side, so mid is the peak element
            if (leftElement < arr[mid] && rightElement < arr[mid]) return mid;

            // Peak is on the left side
            if (leftElement >= arr[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return -1;
    }
}
