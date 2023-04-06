package com.graphs.bfs_for_shortest_path.snakes_and_ladders;

import java.util.LinkedList;
import java.util.Queue;

public class SnakesAndLadders {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;  // get the size of the board
        int[] flattenedBoard = flattenBoard(board, n); // convert the 2D board to a 1D array
        boolean[] visited = new boolean[n * n + 1]; // keep track of visited cells
        Queue<Integer> queue = new LinkedList<>(); // use a queue to explore cells

        int steps = 0; // keep track of the number of steps

        queue.offer(1); // start from cell 1
        visited[1] = true; // mark it as visited

        while (!queue.isEmpty()) { // repeat until all cells are visited
            int size = queue.size(); // get the number of cells at this level

            for (int i = 0; i < size; i++) { // explore cells at this level
                int cell = queue.poll(); // remove the first cell from the queue

                if (cell == n * n) { // if we reach the last cell, return the number of steps
                    return steps;
                }

                // try all possible moves, next move also has to be less than or equal to board length (n * n)
                for (int j = 1; j <= 6 && cell + j <= n * n; j++) {
                    int nextCell = flattenedBoard[cell + j] == -1 ? cell + j : flattenedBoard[cell + j]; // get the next cell after the move

                    if (!visited[nextCell]) { // if the next cell is not visited yet
                        visited[nextCell] = true; // mark it as visited
                        queue.offer(nextCell); // add it to the queue
                    }
                }
            }

            steps++; // increment the number of steps after exploring all cells at this level
        }

        return -1; // if we cannot reach the last cell, return -1
    }

    private int[] flattenBoard(int[][] board, int n) { // method to convert 2D board to 1D array
        int[] flattenedBoard = new int[n * n + 1]; // create a new array
        int index = 1; // start from index 1
        boolean isForward = true; // flag to indicate whether we are moving left-to-right or right-to-left

        for (int i = n - 1; i >= 0; i--) { // loop over rows in reverse order
            if (isForward) { // if we are moving left-to-right
                for (int j = 0; j < n; j++) { // loop over columns from left to right
                    flattenedBoard[index++] = board[i][j]; // add the cell value to the flattened array
                }
            } else { // if we are moving right-to-left
                for (int j = n - 1; j >= 0; j--) { // loop over columns from right to left
                    flattenedBoard[index++] = board[i][j]; // add the cell value to the flattened array
                }
            }

            isForward = !isForward; // switch the direction of movement
        }

        return flattenedBoard; // return the flattened 1D array
    }
}

