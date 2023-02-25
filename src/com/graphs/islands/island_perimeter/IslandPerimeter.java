package com.graphs.islands.island_perimeter;

public class IslandPerimeter {
    public int islandPerimeter(int[][] grid) {
        int rows = grid.length, columns = grid[0].length;
        int perimeter = 0;

        // Iterate the grid and perform dfs if an island is found, to find its perimeter
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (grid[i][j] == 1) {
                    perimeter += dfs(i, j, rows, columns, grid);
                }
            }
        }

        return perimeter;
    }

    private int dfs(int row, int col, int rows, int columns, int[][] grid) {
        // If we are out of the boundary or at water, return 1 as it is a perimeter of the island
        if (row < 0 || row >= rows || col < 0 || col >= columns || grid[row][col] == 0) return 1;

        // The cell is a visited land so return 0
        if (grid[row][col] == -1) return 0;

        // Mark the land as visited
        grid[row][col] = -1;

        int value = 0;

        // Traverse top, down, left, right to find the perimeter of the island
        value += dfs(row - 1, col, rows, columns, grid);
        value += dfs(row + 1, col, rows, columns, grid);
        value += dfs(row, col - 1, rows, columns, grid);
        value += dfs(row, col + 1, rows, columns, grid);

        return value;
    }
}
