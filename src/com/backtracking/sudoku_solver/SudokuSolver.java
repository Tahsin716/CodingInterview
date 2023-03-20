package com.backtracking.sudoku_solver;

public class SudokuSolver {
    public void solveSudoku(char[][] board) {
        solve(board);
    }

    // Recursive function to solve the Sudoku puzzle using backtracking
    private boolean solve(char[][] board) {
        // Iterate through each cell of the board
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                // Check if the cell is empty, if it is not continue
                if (board[row][col] != '.') continue;

                // Try all possible values for the empty cell
                for (char c = '1'; c <= '9'; c++) {
                    // Check if the value is valid for the cell
                    if (!isValidSudoku(board, row, col, c)) continue;

                    // If the value is valid, set the cell to the value
                    board[row][col] = c;

                    // Recursively solve the board with the updated cell value
                    if (solve(board)) return true;

                    // If the recursion doesn't work, backtrack and try another value
                    board[row][col] = '.';
                }

                // If no value works for the cell, backtrack and return false
                return false;
            }
        }

        // If all cells are filled, return true
        return true;
    }

    // Function to check if the given value is valid for the cell
    private boolean isValidSudoku(char[][] board, int row, int col, char c) {
        int subBoxRowStart = 3 * (row / 3);
        int subBoxColStart = 3 * (col / 3);

        // Check the row, column, and sub-box for the given value
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == c) return false;
            if (board[row][i] == c) return false;

            int subBoxRowOffset = i / 3;
            int subBoxColOffset = i % 3;

            if (board[subBoxRowStart + subBoxRowOffset][subBoxColStart + subBoxColOffset] == c) return false;
        }

        // If the value is valid, return true
        return true;
    }
}

