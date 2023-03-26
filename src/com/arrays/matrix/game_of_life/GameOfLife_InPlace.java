package com.arrays.matrix.game_of_life;

public class GameOfLife_InPlace {
    // Define the relative positions of the 8 neighbors of a cell
    private int[] dx = new int[]{1, -1, 0, 0, 1, 1, -1, -1};
    private int[] dy = new int[]{0, 0, 1, -1, 1, -1, 1, -1};


    public void gameOfLife(int[][] board) {
        // Get the number of rows and columns in the board
        int rows = board.length, columns = board[0].length;

        // Iterate through each cell in the original board
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                // Count the number of live neighbors for the current cell
                int liveCount = getLiveCount(row, col, rows, columns, board);

                // Apply the rules of the Game of Life to update the current cell
                if (board[row][col] == 1 && liveCount < 2) {
                    board[row][col] = -1;
                } else if (board[row][col] == 1 && liveCount > 3) {
                    board[row][col] = -1;
                } else if (board[row][col] == 0 && liveCount == 3) {
                    board[row][col] = 2;
                }
            }
        }

        // Iterate the board to update the markings
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                // Update  2 = 1
                // Update -1 = 0
                if (board[row][col] > 0) {
                    board[row][col] = 1;
                } else {
                    board[row][col] = 0;
                }
            }
        }
    }

    private int getLiveCount(int row, int col, int rows, int columns, int[][] board) {
        int liveCount = 0;

        for (int i = 0; i < 8; i++) {
            int nextX = row + dx[i];
            int nextY = col + dy[i];

            // Check if the neighbor is valid and alive
            //  1 = current 1
            // -1 = previous 1, current 0
            if (isValidCell(nextX, nextY, rows, columns)
                    && (board[nextX][nextY] == 1 || board[nextX][nextY] == -1)) liveCount++;
        }

        return liveCount;
    }

    private boolean isValidCell(int row, int col, int rows, int columns) {
        return row >= 0 && row < rows && col >= 0 && col < columns;
    }
}
