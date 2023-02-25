package com.graphs.islands.max_area_of_island;

public class MaxAreaOfIsland {
    public int maxAreaOfIsland(int[][] grid) {
        int rows = grid.length, columns = grid[0].length;

        int maxArea = 0;

        // Iterate the grid, and perform dfs if an island is found to find its area
        // and use maxArea variable to store the maximum area found for the islands
        for (int i = 0; i < rows; i ++) {
            for (int j = 0; j < columns; j++) {
                if (grid[i][j] == 0) continue;

                maxArea = Math.max(dfs(i, j, rows, columns, grid), maxArea);
            }
        }

        return maxArea;
    }

    public int dfs(int row, int col, int rows, int columns, int[][] grid) {
        if (row < 0 || row >= rows || col < 0 || col >= columns || grid[row][col] == 0) return 0;

        grid[row][col] = 0;

        int value = 1;

        value += dfs(row - 1, col, rows, columns, grid);
        value += dfs(row + 1, col, rows, columns, grid);
        value += dfs(row, col - 1, rows, columns, grid);
        value += dfs(row, col + 1, rows, columns, grid);

        return value;
    }
}
