package com.graphs.bfs_for_shortest_path.as_far_from_land_as_possible;

import java.util.LinkedList;
import java.util.Queue;

public class AsFarFromLandAsPossible {
    public int maxDistance(int[][] grid) {
        int rows = grid.length;
        int columns = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();

        // Add all land cells to the queue
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (grid[i][j] == 1) {
                    queue.offer(new int[]{i, j});
                }
            }
        }

        // If there are no land or water cells, return -1
        if (queue.isEmpty() || queue.size() == rows * columns) return -1;

        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int maxDistance = -1;

        // Breadth-first search to find the nearest land cell for each water cell
        while (!queue.isEmpty()) {
            // we need to iterate over the size of the queue at the beginning of the level to ensure
            // that we only visit cells that are at the current level and do not accidentally visit cells that were added
            // to the queue in a previous level. If we did not do this, we would end up visiting some cells multiple times,
            // which would result in incorrect distances being calculated.
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();
                int currentRow = current[0];
                int currentColumn = current[1];

                // Check all adjacent cells
                for (int[] dir : directions) {
                    int neighbourRow = currentRow + dir[0];
                    int neighbourColumn = currentColumn + dir[1];

                    // If the adjacent neighbour is out of bounds or the grid and is not water, continue
                    if (neighbourRow < 0 || neighbourRow >= rows || neighbourColumn < 0 || neighbourColumn > columns || grid[neighbourRow][neighbourColumn] == 0) continue;

                    // Set the distance to the nearest land current for the adjacent current
                    grid[neighbourColumn][neighbourColumn] = grid[currentRow][currentColumn] + 1;
                    // Add the adjacent current to the queue
                    queue.offer(new int[]{neighbourRow, neighbourColumn});
                    // Update the maxDistance.
                    // maxDistance represents the maximum distance to the nearest land cell among all water cells in the grid
                    // minus one to adjust for the fact that we added one when marking the distance to a land cell in the grid array.
                    maxDistance = Math.max(maxDistance, grid[neighbourRow][neighbourColumn] - 1);
                }
            }
        }

        return maxDistance;
    }
}


