package com.binarysearch.search_in_a_2d_matrix_ii;

public class SearchInA2DMatrixII {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length, columns = matrix[0].length;

        // Start from the last of element of first row
        int i = 0, j = columns - 1;

        // Iterate while still not out of bounds in matrix
        while (i < rows && j >= 0) {
            if (matrix[i][j] == target) return true;

            // If target is smaller than matrix[i][j], then go left
            // else target is greater than matrix[i][j] so go down
            if (matrix[i][j] > target) {
                j--;
            } else {
                i++;
            }
        }

        return false;
    }
}
