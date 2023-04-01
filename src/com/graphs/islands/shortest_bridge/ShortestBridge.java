package com.graphs.islands.shortest_bridge;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestBridge {
    // A queue to store the coordinates of the islands.
    private Queue<int[]> queue;
    // The four possible directions in which we can move from a given cell.
    private int[][] directions = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public int shortestBridge(int[][] grid) {
        // get the number of rows and columns in the grid
        int rows = grid.length;
        int columns = grid[0].length;

        // initialize variables for BFS
        queue = new LinkedList<>();
        boolean firstIslandFloodFilled = false;
        boolean[][] visited = new boolean[rows][columns];

        // Find the first island using DFS and add it to the queue.
        // Also mark the coordinates as visited
        for (int i = 0; i < rows && !firstIslandFloodFilled; i++) {
            for (int j = 0; j < columns; j++) {
                if (grid[i][j] == 1) {
                    floodFill(i, j, rows, columns, grid, visited);
                    firstIslandFloodFilled = true;
                    break;
                }
            }
        }

        // use BFS to find the shortest bridge to the second island
        int minFlips = 0;
        while (!queue.isEmpty()) {
            int currentLevel = queue.size();

            // process all nodes in the current level
            for (int i = 0; i < currentLevel; i++) {
                int[] current = queue.poll();
                int row = current[0];
                int col = current[1];

                // check all neighbors of the current node
                for (int[] dir : directions) {
                    int nextRow = row + dir[0];
                    int nextCol = col + dir[1];

                    // skip nodes outside the grid or already visited
                    if (nextRow < 0 || nextCol < 0 || nextRow >= rows || nextCol >= columns
                            || visited[nextRow][nextCol]) continue;

                    // if we find the second island, return the minimum flips to reach it
                    // as using BFS it is guaranteed to find the shortest path, so return the minFlips
                    if (grid[nextRow][nextCol] == 1) {
                        return minFlips;
                    }

                    // add the neighboring node to the queue and mark it as visited
                    queue.offer(new int[]{nextRow, nextCol});
                    visited[nextRow][nextCol] = true;
                }
            }

            // increment the number of flips for each level of BFS
            minFlips++;
        }

        // if we don't find the second island, return -1
        return -1;
    }

    // flood-fill algorithm to find the first island using DFS
    private void floodFill(int row, int col, int rows, int columns, int[][] grid, boolean[][] visited) {
        // base cases: out of bounds or already visited or water
        if (row < 0 || col < 0 || row >= rows || col >= columns || visited[row][col] || grid[row][col] == 0) return;

        // mark the current node as visited and add it to the queue
        visited[row][col] = true;
        queue.offer(new int[]{row, col});

        // recursively visit all neighboring nodes
        floodFill(row + 1, col, rows, columns, grid, visited);
        floodFill(row - 1, col, rows, columns, grid, visited);
        floodFill(row, col + 1, rows, columns, grid, visited);
        floodFill(row, col - 1, rows, columns, grid, visited);
    }
}

