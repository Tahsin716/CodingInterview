package com.backtracking.word_search;

public class WordSearch {
    public boolean exist(char[][] board, String word) {
        // get number of rows and columns of the board
        int rows = board.length, columns = board[0].length;

        // loop through all cells on the board
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < columns; j++)
                // if the first letter of the word matches the current cell's letter, start DFS
                if (word.charAt(0) == board[i][j] && dfs(board, word, i, j, 0)) return true;

        // if DFS doesn't find a solution, return false
        return false;
    }

    private boolean dfs(char[][] board, String word, int row, int col, int index) {
        // if we've matched all letters in the word, we've found a solution
        if (index == word.length()) return true;

        // check if current cell is out of bounds or doesn't match the current letter of the word
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length
                || board[row][col] != word.charAt(index)) return false;

        // mark current cell as visited
        board[row][col] = '0';

        // recursively search for next letter of the word in adjacent cells
        if (dfs(board, word, row + 1, col, index + 1) ||
                dfs(board, word, row - 1, col, index + 1) ||
                dfs(board, word, row, col - 1, index + 1) ||
                dfs(board, word, row, col + 1, index + 1)) return true;

        // unmark current cell as visited
        board[row][col] = word.charAt(index);

        // if no solution is found, return false
        return false;
    }
}

