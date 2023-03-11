package com.graphs.dfs_from_boundary.pacific_atlantic_water_flow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PacificAtlanticWaterFlow {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int rows = heights.length;
        int columns = heights[0].length;

        // Create two boolean matrices to keep track of cells that are reachable from Pacific and Atlantic ocean respectively.
        boolean[][] pacific = new boolean[rows][columns];
        boolean[][] atlantic = new boolean[rows][columns];

        // Traverse along the left and right columns of the matrix and perform DFS to find cells that are reachable from Pacific and Atlantic oceans respectively.
        for (int row = 0; row < rows; row++) {
            dfs(heights, pacific, heights[row][0], row, 0, rows, columns);
            dfs(heights, atlantic, heights[row][columns - 1], row, columns - 1, rows, columns);
        }

        // Traverse along the top and bottom rows of the matrix and perform DFS to find cells that are reachable from Pacific and Atlantic oceans respectively.
        for (int col = 0; col < columns; col++) {
            dfs(heights, pacific, heights[0][col], 0, col, rows, columns);
            dfs(heights, atlantic, heights[rows - 1][col], rows - 1, col, rows, columns);
        }

        // Create a list to store the result, which will contain the cells that are reachable from both the oceans.
        List<List<Integer>> result = new ArrayList<>();

        // Traverse through the matrix and add the cell to the result list if it is reachable from both the oceans.
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                if (pacific[row][col] && atlantic[row][col]) {
                    result.add(Arrays.asList(row, col));
                }
            }
        }

        // Return the final result list.
        return result;
    }

    // Helper function that performs DFS to find the cells that are reachable from a given cell in the matrix.
    private void dfs(int[][] heights, boolean[][] visited, int height, int row, int col, int rows, int columns) {
        // If the current cell is out of bounds or already visited or its height is less than the height of the previous cell, return.
        if (row < 0 || row >= rows || col < 0 || col >= columns || visited[row][col] || heights[row][col] < height) return;

        // Mark the current cell as visited and update the height.
        visited[row][col] = true;
        height = heights[row][col];

        // Recursively call the DFS function for the neighboring cells.
        dfs(heights, visited, height, row + 1, col, rows, columns);
        dfs(heights, visited, height, row, col + 1, rows, columns);
        dfs(heights, visited, height, row - 1, col, rows, columns);
        dfs(heights, visited, height, row, col - 1, rows, columns);
    }
}

