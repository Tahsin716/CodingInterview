package com.arrays.matrix.spiral_matrix;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    // Define a method for the Spiral Matrix
    public List<Integer> spiralOrder(int[][] matrix) {
        // Create a new list to store the result
        List<Integer> result = new ArrayList<>();

        // Define the indices for the start and end of rows and columns
        int rowStart = 0, colStart = 0;
        int rowEnd = matrix.length - 1, colEnd = matrix[0].length - 1;

        // While the start indices are less than or equal to the end indices
        while (rowStart <= rowEnd && colStart <= colEnd) {

            // Traverse from left to right of the top row
            for (int i = colStart; i <= colEnd; i++) result.add(matrix[rowStart][i]);
            rowStart++;

            // Traverse from top to bottom of the right column
            for (int j = rowStart; j <= rowEnd; j++) result.add(matrix[j][colEnd]);
            colEnd--;

            // Check if all elements have been traversed
            if (rowStart > rowEnd || colStart > colEnd) break;

            // Traverse from right to left of the bottom row
            for (int i = colEnd; i >= colStart; i--) result.add(matrix[rowEnd][i]);
            rowEnd--;

            // Traverse from bottom to top of the left column
            for (int j = rowEnd; j >= rowStart; j--) result.add(matrix[j][colStart]);
            colStart++;
        }

        // Return the result list
        return result;
    }
}
