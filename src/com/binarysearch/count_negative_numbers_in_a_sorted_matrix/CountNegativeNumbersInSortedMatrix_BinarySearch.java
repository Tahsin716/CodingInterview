package com.binarysearch.count_negative_numbers_in_a_sorted_matrix;

public class CountNegativeNumbersInSortedMatrix_BinarySearch {
    public int countNegatives(int[][] grid) {
        int count = 0;

        // Loop through each row of the grid
        for (int[] row : grid) {
            // Call binarySearch function to count negative numbers in the current row
            count += binarySearch(row);
        }

        return count;
    }

    // Performs binary search on the input integer array
    private int binarySearch(int[] arr) {
        int start = 0, end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            // If the middle element is negative, search in the left half of the array
            if (arr[mid] < 0) {
                end = mid - 1;
            }
            // Otherwise, search in the right half of the array
            else {
                start = mid + 1;
            }
        }

        // The number of negative integers in the array is arr.length - start
        return arr.length - start;
    }
}
