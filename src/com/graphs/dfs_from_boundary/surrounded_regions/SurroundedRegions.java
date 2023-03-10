package com.graphs.dfs_from_boundary.surrounded_regions;

public class SurroundedRegions {
    public void solve(char[][] board) {
        int rows = board.length, columns = board[0].length;

        // Iterate the boundary rows, and flood fill the 'O's that are connected to the boundary
        for (int i = 0; i < rows; i++) {
            if (board[i][0] == 'O') dfs(board, i, 0, rows, columns);

            if (board[i][columns - 1] == 'O') dfs(board, i, columns - 1, rows, columns);
        }

        // Iterate the boundary columns, and flood fill the 'O's that are connected to the boundary
        for (int j = 0; j < columns; j++) {
            if (board[0][j] == 'O') dfs(board, 0, j, rows, columns);

            if (board[rows - 1][j] == 'O') dfs(board, rows - 1, j, rows, columns);
        }

        // Iterate the grid, flip the remaining 'O's to 'X' as they weren't connected to the boundary
        // and the '#'s into 'O'
        for (int i = 0; i < rows; i++)  {
            for (int j = 0; j < columns; j++) {
                if (board[i][j] == 'O') board[i][j] = 'X';

                if (board[i][j] == '#') board[i][j] = 'O';
            }
        }

    }

    private void dfs(char[][] board, int row, int col, int rows, int columns) {
        if (row < 0 || col  < 0 || row >= rows || col >= columns || board[row][col] != 'O') return;

        board[row][col] = '#';

        dfs(board, row - 1, col, rows, columns);
        dfs(board, row + 1, col, rows, columns);
        dfs(board, row, col - 1, rows, columns);
        dfs(board, row, col + 1, rows, columns);
    }
}
