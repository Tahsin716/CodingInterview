package com.graphs.bfs_for_shortest_path.rotting_oranges;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int columns = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();

        // Initialize variables for the total number of oranges, minutes elapsed, and rotten oranges
        int total = 0, minutes = 0, rotten = 0;

        // Iterate over the entire grid to find the rotten oranges and total number of oranges
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (grid[i][j] == 2) {
                    // Add rotten oranges to the queue
                    queue.offer(new int[]{i, j});
                }
                if (grid[i][j] == 1 || grid[i][j] == 2) {
                    // Count all fresh and rotten oranges
                    total++;
                }
            }
        }

        // If there are no oranges, no time has elapsed
        if (total == 0) return 0;

        // Define the possible directions to spread the rot
        int[][] directions = new int[][]{{1, 0}, {0, -1}, {-1, 0}, {0, 1}};

        // Continue until there are no more oranges to rot
        while (!queue.isEmpty()) {
            // We need to iterate over the rotten oranges of the current level,
            // it is so that we don't iterate over cells added from previous level
            // we need count of the number of rotten oranges at each level
            int size = queue.size();

            // Count the number of oranges that have rotted in this iteration
            rotten += size;

            // If all oranges have rotted, return the elapsed time
            if (rotten == total) return minutes;

            for (int i = 0; i < size; i++) {
                // Remove the top orange from the queue
                int[] top = queue.poll();
                int currentRow = top[0];
                int currentColumn = top[1];

                for (int[] dir : directions) {
                    // Calculate the row of the neighbouring orange
                    int neighbourRow = currentRow + dir[0];
                    // Calculate the column of the neighbouring orange
                    int neighbourColumn = currentColumn + dir[1];

                    // Skip any oranges that are out of bounds, already rotten, or empty
                    if (neighbourRow < 0 || neighbourRow >= rows || neighbourColumn < 0 || neighbourColumn >= columns
                            || grid[neighbourRow][neighbourColumn] == 0
                            || grid[neighbourRow][neighbourColumn] == 2) continue;

                    // Mark the neighbouring orange as rotten
                    grid[neighbourRow][neighbourColumn] = 2;
                    // Add the neighbouring orange to the queue
                    queue.offer(new int[]{neighbourRow, neighbourColumn});
                }
            }

            // Increment the elapsed time after all oranges in this iteration have rotted
            minutes++;
        }

        // If all oranges cannot be rotten, return -1
        return -1;
    }
}

