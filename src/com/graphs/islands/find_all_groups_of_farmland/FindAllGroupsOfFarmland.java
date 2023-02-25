package com.graphs.islands.find_all_groups_of_farmland;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllGroupsOfFarmland {
    public int[][] findFarmland(int[][] land) {
        int rows = land.length, columns = land[0].length;
        List<List<Integer>> result = new ArrayList<>();

        // Iterate the grid
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (land[i][j] == 0) continue;

                // i = startRow, row - 1 = lastRow
                // j = startCol, col - 1 = lastCol
                int row = i, col = j;

                // After while loop break, row and col are +1 more
                // than actual value
                while (row < rows && land[row][j] == 1) row++;
                while (col < columns && land[i][col] == 1) col++;

                // flood fill the land, to mark them as visited
                fill(land, i, j, row, col);

                result.add(new ArrayList<>(Arrays.asList(i, j, row - 1, col - 1)));
            }
        }

        return result.stream()
                .map(l -> l.stream().mapToInt(Integer::intValue).toArray())
                .toArray(int[][]::new);
    }

    private void fill(int[][] land, int r1, int c1, int r2, int c2) {
        for (int i = r1; i < r2; i++) {
            for (int j = c1; j < c2; j++) {
                land[i][j] = 0;
            }
        }
    }
}
