package com.graphs.islands.number_of_islands;

public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        if (grid.length == 0) return 0;

        int rows = grid.length, columns = grid[0].length;
        int count = 0;

        // Iterate the grid, and perform a dfs if an island is found
        // to flood fill the island as visited
        // increment the count as an island was found.
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                if (grid[row][col] == '1') {
                    dfs(grid, row, col, rows, columns);
                    count++;
                }
            }
        }

        return count;
    }

    private void dfs(char[][] grid, int row, int col, int rows, int columns) {
        if (row < 0 || col < 0 || row >= rows || col >= columns || grid[row][col] != '1') return;

        grid[row][col] = '0';

        dfs(grid, row + 1, col, rows, columns);
        dfs(grid, row - 1, col, rows, columns);
        dfs(grid, row, col + 1, rows, columns);
        dfs(grid, row, col - 1, rows, columns);
    }
}
