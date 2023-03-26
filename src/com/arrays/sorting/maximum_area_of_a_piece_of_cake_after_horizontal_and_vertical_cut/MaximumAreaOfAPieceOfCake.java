package com.arrays.sorting.maximum_area_of_a_piece_of_cake_after_horizontal_and_vertical_cut;

import java.util.Arrays;

public class MaximumAreaOfAPieceOfCake {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        int mod = 1000000007; // constant to take modulo of answer

        // sort the cut arrays to make it easier to find max height and width
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);

        // find the maximum height and width of the cake
        int maxHeight = Math.max(horizontalCuts[0], h - horizontalCuts[horizontalCuts.length - 1]);
        int maxWidth = Math.max(verticalCuts[0], w - verticalCuts[verticalCuts.length - 1]);

        // iterate over vertical cuts to find the maximum width of the pieces
        for (int i = 0; i < verticalCuts.length - 1; i++)
            maxWidth = Math.max(maxWidth, verticalCuts[i + 1] - verticalCuts[i]);

        // iterate over horizontal cuts to find the maximum height of the pieces
        for (int i = 0; i < horizontalCuts.length - 1; i++)
            maxHeight = Math.max(maxHeight, horizontalCuts[i + 1] - horizontalCuts[i]);

        // calculate and return the maximum area using the formula (height * width) % mod
        return (int)((long)maxHeight * maxWidth % mod);
    }
}

