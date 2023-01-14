package com.binarysearch.search_in_a_2d_matrix;

public class SearchInA2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length, columns = matrix[0].length;

        // We will treat the 2D matrix as a 1D matrix, so end = row * columns - 1
        // gives us the last element in the matrix
        int start = 0, end = row * columns - 1, mid;

        while (start <= end) {
            mid = start + (end - start) / 2;

            // Every row we have 'm' columns, so mid / m gives us the row
            // midElement = matrix[mid / col][mid % col]
            int midElement = matrix[mid / columns][mid % columns];

            if (midElement == target) return true;

            if (midElement > target) {
                end--;
            } else {
                start++;
            }
        }

        return false;
    }
}
