package com.arrays.matrix.game_of_life;

public class GameOfLife {
    // Define the relative positions of the 8 neighbors of a cell
    private int[] dx = new int[]{1, -1, 0, 0, 1, 1, -1, -1};
    private int[] dy = new int[]{0, 0, 1, -1, 1, -1, 1, -1};

    public void gameOfLife(int[][] board) {
        // Get the number of rows and columns in the board
        int rows = board.length, columns = board[0].length;

        // Create a new board to copy the original board into
        int[][] copiedBoard = new int[rows][columns];

        // Copy the original board into the new board
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < columns; j++)
                copiedBoard[i][j] = board[i][j];

        // Iterate through each cell in the original board
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                // Count the number of live neighbors for the current cell
                int liveCount =  getLiveCount(row, col, rows, columns, copiedBoard);

                // Apply the rules of the Game of Life to update the current cell
                if (copiedBoard[row][col] == 1 && liveCount < 2) {
                    board[row][col] = 0;
                } else if (copiedBoard[row][col] == 1 && liveCount > 3) {
                    board[row][col] = 0;
                } else if (copiedBoard[row][col] == 0 && liveCount == 3) {
                    board[row][col] = 1;
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
            if (isValidCell(nextX, nextY, rows, columns)
                    && board[nextX][nextY] == 1) liveCount++;
        }

        return liveCount;
    }

    // Check if a cell is valid (within the bounds of the board)
    private boolean isValidCell(int row, int col, int rows, int columns) {
        return row >= 0 && row < rows && col >= 0 && col < columns;
    }
}

