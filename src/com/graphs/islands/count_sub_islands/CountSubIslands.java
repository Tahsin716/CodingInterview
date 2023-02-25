package com.graphs.islands.count_sub_islands;

public class CountSubIslands {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int rows = grid1.length, columns = grid1[0].length;
        int count = 0;

        // Iterate the grid and if the cell is an island, perform a dfs traversal to check if it is a sub island
        // if yes, then increment count as we found a sub island
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (grid2[i][j] == 1 && dfs(i, j, rows, columns, grid1, grid2)) {
                    count++;
                }
            }
        }

        return count;
    }

    private boolean dfs(int row, int col, int rows, int columns, int[][] grid1, int[][] grid2) {
        // If out of boundary or the cell is water then return true as it is a sub island
        // this is because we will never reach this condition for a single cell, as we have
        // previously checked during grid iteration that grid[i][j] is an island.
        if (row < 0 || row >= rows || col < 0 || col >= columns || grid2[row][col] == 0) return true;

        // grid1[row][col] is not an island so return false
        if (grid1[row][col] != grid2[row][col]) return false;

        // flood fill grid2, i.e. mark it as visited
        grid2[row][col] = 0;

        // Traverse top, down, left and right to check if they are sub islands as well
        boolean top = dfs(row - 1, col, rows, columns, grid1, grid2);
        boolean down = dfs(row + 1, col, rows, columns, grid1, grid2);
        boolean left = dfs(row, col - 1, rows, columns, grid1, grid2);
        boolean right = dfs(row, col + 1, rows, columns, grid1, grid2);

        // return true if they all are sub islands
        return top && down && right && left;
    }
}
