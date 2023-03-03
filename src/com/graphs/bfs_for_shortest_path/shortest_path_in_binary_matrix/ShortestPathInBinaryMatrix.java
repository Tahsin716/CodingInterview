package com.graphs.bfs_for_shortest_path.shortest_path_in_binary_matrix;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathInBinaryMatrix {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int rows = grid.length;
        int columns = grid[0].length;

        // Check if starting and ending point is valid
        if (grid[0][0] == 1 || grid[rows - 1][columns - 1] == 1) return -1;

        // Initialize a queue and a visited matrix
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[rows][columns];

        // Add the starting point to the queue and mark it as visited
        queue.add(new int[]{0, 0});
        visited[0][0] = true;

        // Define possible directions in which the search can move
        int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, -1}, {-1, 1}, {-1, -1}, {1, 1}};

        // Initialize the path length
        int path = 0;

        // BFS algorithm
        while (!queue.isEmpty()) {
            // Keep track of the number of elements at the current level
            // keeping track of the current level is useful
            // because it allows us to increment the path length only once for each level of nodes
            int size = queue.size();

            // Increment the path length
            path++;

            // Traverse all the nodes at the current level
            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();
                int currentRow = current[0];
                int currentColumn = current[1];

                // Check if the current node is the destination node
                if (currentRow == rows - 1 && currentColumn == columns - 1) return path;

                // Traverse all the neighbors of the current node
                for (int[] dir : directions) {
                    int neighbourRow = currentRow + dir[0];
                    int neighbourColumn = currentColumn + dir[1];

                    // Check if the neighbor node is within the bounds of the matrix,
                    // has not been visited before, and is not blocked by a 1
                    if (neighbourRow < 0 || neighbourRow >= rows
                            || neighbourColumn < 0 || neighbourColumn >= columns
                            || visited[neighbourRow][neighbourColumn]
                            || grid[neighbourRow][neighbourColumn] == 1) continue;

                    // Add the neighbor node to the queue and mark it as visited
                    queue.add(new int[]{neighbourRow, neighbourColumn});
                    visited[neighbourRow][neighbourColumn] = true;
                }
            }
        }

        // If the BFS algorithm completes without finding the destination node,
        // return -1 indicating that there is no valid path
        return -1;
    }
}
