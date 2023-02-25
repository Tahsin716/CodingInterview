package com.graphs.islands.number_of_closed_islands;

public class NumberOfClosedIslands {
    public int closedIsland(int[][] grid) {
        int rows = grid.length, columns = grid[0].length;
        int count = 0;

        // Iterate the boundary rows and flood fill the islands that are connected to the boundary
        for (int i = 0; i < rows; i++) {
            if (grid[i][0] == 0) floodFill(i, 0, rows, columns, grid);

            if (grid[i][columns - 1] == 0) floodFill(i, columns - 1, rows, columns, grid);
        }

        // Iterate the boundary columns and flood fill the islands that are connected to the boundary
        for (int j = 0; j < columns; j++) {
            if (grid[0][j] == 0) floodFill(0, j, rows, columns, grid);

            if (grid[rows - 1][j] == 0) floodFill(rows - 1, j, rows, columns, grid);
        }

        // Iterate the grid, and flood fill the remaining islands not connected to the boundary
        // and increment the counter as an island was found.
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (grid[i][j] == 0) {
                    floodFill(i, j, rows, columns, grid);
                    count++;
                }
            }
        }

        return count;
    }

    private void floodFill(int row, int col, int rows, int columns, int[][] grid) {
        if (row < 0 || row >= rows || col < 0 || col >= columns || grid[row][col] == 1) return;

        grid[row][col] = 1;

        floodFill(row + 1, col, rows, columns, grid);
        floodFill(row - 1, col, rows, columns, grid);
        floodFill(row, col + 1, rows, columns, grid);
        floodFill(row, col - 1, rows, columns, grid);
    }
}
