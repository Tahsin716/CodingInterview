package com.heaps.k_way_merge.kth_smallest_element_in_a_sorted_matrix;

public class KthSmallestElementInASortedMatrix_BinarySearch {
    // This method finds the kth smallest, element in a 2D matrix using binary search.
    public int kthSmallest(int[][] matrix, int k) {
        // First, we set the start and end values to the top-left and bottom-right
        // elements in the matrix respectively.
        int start = matrix[0][0];
        int end = matrix[matrix.length - 1][matrix[0].length - 1];

        // We loop until the start and end values meet or cross.
        while (start <= end) {
            // We calculate the middle value using binary search.
            int mid = start + (end - start) / 2;

            // We count the number of elements in the matrix that are less than or
            // equal to the middle value.
            int count = getCount(matrix, mid);

            // If the count is less than k, we need to move the start pointer to the right
            // to find a larger value.
            if (count < k) {
                start = mid + 1;
            }
            // If the count is greater than or equal to k, we need to move the end pointer
            // to the left to find a smaller value.
            else {
                end = mid - 1;
            }
        }

        // We return the value of start, which will be the kth smallest, element.
        return start;
    }

    // This method counts the number of elements in a matrix that are less than or equal to x.
    private int getCount(int[][] matrix, int x) {
        // We set the initial count to 0.
        int count = 0;

        // We start in the top-right corner of the matrix.
        int j = matrix[0].length - 1;

        // We loop through each row of the matrix.
        for (int i = 0; i < matrix.length; i++) {
            // We move left in the row until we find the last element that is less than or equal to x.
            while (j >= 0 && matrix[i][j] > x) {
                j--;
            }

            // We add the number of elements in the row that are less than or equal to x to the count.
            count += j + 1;
        }

        // We return the final count.
        return count;
    }
}
