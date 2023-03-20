package com.backtracking.n_queens;

import java.util.*;

public class N_Queens {
    // This method returns all distinct solutions to the n-queens puzzle
    public List<List<String>> solveNQueens(int n) {
        // create a list to hold all the distinct solutions
        List<List<String>> result = new ArrayList<>();

        // create a 2D array to represent the chessboard
        char[][] board = new char[n][n];

        // fill the board with empty spaces initially
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        // start backtracking from the first row
        backtrack(board, result, 0);

        return result;
    }

    // This method performs backtracking to find all solutions to the n-queens puzzle
    private void backtrack(char[][] board, List<List<String>> result, int row) {
        // if we've reached the last row, add the current solution to the list and return
        if (row == board.length) {
            result.add(constructBoard(board));
            return;
        }

        int n = board.length;

        // try placing a queen in each column of the current row
        for (int col = 0; col < n; col++) {
            // if it's a valid placement, mark it on the board and move on to the next row
            // and then backtrack by removing the queen from the board
            if (isValid(board, row, col)) {
                board[row][col] = 'Q';
                backtrack(board, result, row + 1);
                board[row][col] = '.';
            }
        }
    }

    // This method checks if it's valid to place a queen in the given row and column
    private boolean isValid(char[][] board, int row, int col) {
        int n = board.length;
        // check if there's already a queen in the same column
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }
        // check if there's already a queen in the same diagonal (upper left to lower right)
        // "↖" direction from current row and col
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        // check if there's already a queen in the same diagonal (upper right to lower left)
        // "↗" direction from current row and col
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        // if there's no queen in the same column or diagonal, it's a valid placement
        //
        // We are placing the queens from top to bottom row, so there are no queens at the bottom
        // of the row, hence we only check, current row's column and diagonals at the top.
        return true;
    }

    // This method constructs a solution from the current board configuration
    private List<String> constructBoard(char[][] board) {
        List<String> solution = new ArrayList<>();
        for (char[] row : board) {
            solution.add(new String(row));
        }
        return solution;
    }
}

