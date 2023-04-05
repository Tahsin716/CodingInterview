package com.binarysearch.count_negative_numbers_in_a_sorted_matrix;

public class CountNegativeNumberInSortedMatrix_BruteForce {
    public int countNegatives(int[][] grid) {
        int count = 0;
        // iterate through each row
        for (int i = 0; i < grid.length; i++) {
            // start from the rightmost column of the row
            int j = grid[i].length - 1;
            // iterate until the first negative number is found, or we reach the left end of the row
            while (j >= 0 && grid[i][j] < 0) {
                j--;
            }
            // the number of negative numbers in the row is the number of elements after the first negative number
            count += grid[i].length - j - 1;
        }

        return count;
    }
}

