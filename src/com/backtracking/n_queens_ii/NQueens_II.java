package com.backtracking.n_queens_ii;

public class NQueens_II {
    // main function to solve the n-queens puzzle
    public int totalNQueens(int n) {
        boolean[][] board = new boolean[n][n]; // create the chessboard as a 2D boolean array
        return backtrack(board, 0); // call the recursive backtrack function to find solutions
    }

    // recursive backtracking function to find solutions
    private int backtrack(boolean[][] board, int row) {
        // base case: if all n queens are placed, we've found a solution
        if (row == board.length) {
            return 1; // return 1 to indicate a solution has been found
        }

        int n = board.length; // get the size of the board
        int count = 0; // a variable to keep track of the number of solutions found

        // try placing a queen in each column of the current row
        for (int col = 0; col < n; col++) {
            if (isValid(board, row, col)) { // check if the placement is valid
                board[row][col] = true; // mark the placement as a queen
                count += backtrack(board, row + 1); // move on to the next row and add the number of solutions found
                board[row][col] = false; // unmarked the placement as a queen (backtracking step)
            }
        }

        return count; // return the total number of solutions found
    }

    // helper function to check if a placement is valid
    private boolean isValid(boolean[][] board, int row, int col) {
        int n = board.length; // get the size of the board

        // check if there is a queen in the same column in any of the previous rows
        for (int i = 0; i < row; i++) {
            if (board[i][col]) {
                return false; // if there is a queen in the same column, the placement is invalid
            }
        }

        // check if there is a queen in the diagonal going up and to the left
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j]) {
                return false; // if there is a queen in the diagonal, the placement is invalid
            }
        }

        // check if there is a queen in the diagonal going up and to the right
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j]) {
                return false; // if there is a queen in the diagonal, the placement is invalid
            }
        }

        return true; // if none of the above conditions are met, the placement is valid
    }
}

