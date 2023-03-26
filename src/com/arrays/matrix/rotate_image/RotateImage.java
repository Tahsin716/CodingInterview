package com.arrays.matrix.rotate_image;

public class RotateImage {
    public void rotate(int[][] matrix) {
        // First transpose the matrix
        transpose(matrix);

        // Then reflect it horizontally to get the rotated matrix
        reflect(matrix);
    }

    private void transpose(int[][] matrix) {
        int n = matrix.length;

        // Iterate over the upper triangular portion of the matrix and swap elements
        // i.e. flip the matrix diagonally. Changing the rows to columns and columns to rows
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    private void reflect(int[][] matrix) {
        int n = matrix.length;

        // Iterate over each row of the matrix and swap elements horizontally
        //  Either keep two pointers at start and end of the row or iterate up until
        //  n/2 (since going beyond that will reverse the array in its original state) and reverse the row
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }
    }
}

