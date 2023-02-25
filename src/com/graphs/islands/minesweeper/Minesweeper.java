package com.graphs.islands.minesweeper;

public class Minesweeper {
    private int[] dx = new int[]{-1, -1, -1, 0, 1, 1, 1, 0};
    private int[] dy = new int[]{-1, 0, 1, 1, 1, 0, -1, -1};

    public char[][] updateBoard(char[][] board, int[] click) {
        int x = click[0], y = click[1];

        // If we clicked on a mine, then the game is over
        // so mark the cell in the board as 'X'
        // else perform a dfs to reveal the cells
        if (board[x][y] == 'M') {
            board[x][y] = 'X';
        } else {
            dfs(board, x, y);
        }

        return board;
    }

    private void dfs(char[][] board, int x, int y) {
        // If out of bounds or the cell has been already revealed, return
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || board[x][y] != 'E') return;

        // Find the number of bombs in adjacent cells
        int numberOfBombs = getNumberOfAdjacentBombs(board, x, y);

        // If there are no adjacent bombs, then recursively reveal adjacent cells
        // else set the number of bombs in the cell
        if (numberOfBombs == 0) {
            board[x][y] = 'B';

            for (int i = 0; i < 8; i++) {
                int currentX = dx[i] + x;
                int currentY = dy[i] + y;

                dfs(board, currentX, currentY);
            }
        } else {
            board[x][y] = (char)('0' + numberOfBombs);
        }
    }

    private int getNumberOfAdjacentBombs(char[][] board, int x, int y) {
        int count = 0;

        for (int i = 0; i < 8; i++) {
            int currentX = dx[i] + x;
            int currentY = dy[i] + y;

            if (currentX < 0 || currentX >= board.length || currentY < 0 || currentY >= board[0].length) continue;

            if (board[currentX][currentY] == 'M') count++;
        }

        return count;
    }
}
