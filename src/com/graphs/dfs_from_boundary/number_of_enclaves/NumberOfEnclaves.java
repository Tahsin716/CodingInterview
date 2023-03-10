package com.graphs.dfs_from_boundary.number_of_enclaves;

// Define a class named Solution
public class NumberOfEnclaves {
    int landCount; // Declare an integer variable named landCount

    // Define a method named numEnclaves that takes a 2D integer array named grid and returns an integer
    public int numEnclaves(int[][] grid) {
        // Get the number of rows and columns of the grid
        int rows = grid.length;
        int columns = grid[0].length;

        // Initialize the landCount to 0
        landCount = 0;

        // For each row, check the first and last column, and call floodfill method for any 1 found
        for (int i = 0; i < rows; i++) {
            if (grid[i][0] == 1) floodfill(i, 0, rows, columns, grid);

            if (grid[i][columns - 1] == 1) floodfill(i, columns - 1, rows, columns, grid);
        }

        // For each column, check the first and last row, and call floodfill method for any 1 found
        for (int j = 0; j < columns; j++) {
            if (grid[0][j] == 1) floodfill(0, j, rows, columns, grid);

            if (grid[rows - 1][j] == 1) floodfill(rows - 1, j, rows, columns, grid);
        }

        // Reset the landCount to 0
        landCount = 0;

        // Traverse the entire grid and call floodfill method for any 1 found
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (grid[i][j] == 1) {
                    floodfill(i, j , rows, columns, grid);
                }
            }
        }

        // Return the value of landCount
        return landCount;
    }

    // Define a private method named floodfill that takes a row, column, rows, columns and a 2D integer array named grid
    private void floodfill(int row, int col, int rows, int columns, int[][] grid) {
        // If the row or column is out of bounds or if the value at the given position is 0, return
        if (row < 0 || row >= rows || col < 0  || col >= columns || grid[row][col] == 0) return;

        // Set the value at the given position to 0
        grid[row][col] = 0;

        // Increment the landCount variable by 1
        landCount++;

        // Call the floodfill method recursively for the neighboring positions
        floodfill(row - 1, col, rows, columns, grid);
        floodfill(row + 1, col, rows, columns, grid);
        floodfill(row, col - 1, rows, columns, grid);
        floodfill(row, col + 1, rows, columns, grid);
    }
}

