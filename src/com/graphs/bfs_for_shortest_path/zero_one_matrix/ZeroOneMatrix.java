package com.graphs.bfs_for_shortest_path.zero_one_matrix;

import java.util.LinkedList;
import java.util.Queue;

public class ZeroOneMatrix {
    public int[][] updateMatrix(int[][] mat) {
        int rows = mat.length;
        int columns = mat[0].length;
        Queue<int[]> queue = new LinkedList<>();

        // Initialize queue with positions of 0's and mark all other positions with -1
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (mat[i][j] == 0) {
                    queue.offer(new int[] {i, j});
                } else {
                    mat[i][j] = -1;
                }
            }
        }

        // Define possible directions in which the search can move
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        // BFS from the 0's to mark distances from nearest 0
        while (!queue.isEmpty()) {
            // Iterate over the current level
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] top = queue.poll();
                int currentRow = top[0];
                int currentColumn = top[1];

                // Visit all neighboring cells and update distances if necessary
                for (int[] dir : directions) {
                    int neighbourRow = currentRow + dir[0];
                    int neighbourCol = currentColumn + dir[1];

                    // If the neighboring cell is out of bounds or already marked with a distance, skip it
                    if (neighbourRow < 0 || neighbourRow >= rows || neighbourCol < 0 || neighbourCol >= columns
                            || mat[neighbourRow][neighbourCol] != -1) continue;

                    // update the distance from the nearest 0 by adding 1 to the distance of the current position
                    mat[neighbourRow][neighbourCol] = mat[currentRow][currentColumn] + 1;
                    // enqueue the neighboring cell into the queue so that its neighbors can be visited in a subsequent iteration
                    queue.offer(new int[] {neighbourRow, neighbourCol});
                }
            }

        }

        return mat;
    }
}

