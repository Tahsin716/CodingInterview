package com.arrays.basic_array.pascals_triangle;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> pascalTriangle = new ArrayList<>();

        // Insert the first row into the result list
        pascalTriangle.add(new ArrayList<>(List.of(1)));

        // Iterate from second row to numRows
        for (int i = 1; i < numRows; i++) {
            List<Integer> newRow = new ArrayList<>();
            // Get the last row, to calculate current row
            List<Integer> lastRow = pascalTriangle.get(pascalTriangle.size() - 1);

            // Insert 1 int front of the current row
            newRow.add(1);

            // Iterate previous row to calculate the elements in current row
            for (int j = 0; j < lastRow.size() - 1; j++) {
                newRow.add(lastRow.get(j) + lastRow.get(j + 1));
            }

            // Insert 1 into end of the current row
            newRow.add(1);
            // Add current row into results list
            pascalTriangle.add(newRow);
        }

        return pascalTriangle;
    }
}
