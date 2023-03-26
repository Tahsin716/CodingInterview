package com.strings.zigzag_conversion;

import java.util.ArrayList;
import java.util.List;

public class ZigzagConversion {
    public String convert(String s, int numRows) {
        // edge case
        if (numRows == 1) {
            return s;
        }

        // create a list of StringBuilder objects to store the zigzag pattern
        List<StringBuilder> rows = new ArrayList<>();

        // The number of rows is capped at the length of the string to prevent out of bounds errors.
        for (int i = 0; i < Math.min(numRows, s.length()); i++) {
            rows.add(new StringBuilder());
        }

        // The row index currentRow is incremented or decremented
        // based on whether the pattern is currently moving downwards or upwards, respectively
        int currentRow = 0;

        // The variable goingDown is used to keep track of the current direction of movement,
        // and is toggled when the pattern reaches the top or bottom row.
        boolean goingDown = false;

        for (char c : s.toCharArray()) {
            rows.get(currentRow).append(c);

            // If we are at the first or last row, we toggle goingDown, to move upwards or downwards
            if (currentRow == 0 || currentRow == numRows - 1) {
                goingDown = !goingDown;
            }

            // If we are going down then we increment currentRow, else decrement
            currentRow += goingDown ? 1 : -1;
        }

        StringBuilder result = new StringBuilder();

        // Concatenate the StringBuilder objects in the list to get the final zigzag pattern
        for (StringBuilder row : rows) {
            result.append(row);
        }

        return result.toString();
    }
}
