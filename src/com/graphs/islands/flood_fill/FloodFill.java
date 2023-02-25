package com.graphs.islands.flood_fill;

public class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        // The starting pixel is already colored as newColor, so no changes are made.
        if (image[sr][sc] == newColor) return image;

        dfs(image, sr, sc, newColor, image[sr][sc]);

        return image;
    }

    // Recursively traverse top, down, left, right while not out of boundary
    // and image color is not equal to sourceColor
    // change the image source color
    public void dfs(int[][] image, int sr, int sc, int newColor, int srcColor) {
        if (sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length || image[sr][sc] != srcColor) return;

        image[sr][sc] = newColor;

        dfs(image, sr - 1, sc, newColor, srcColor);
        dfs(image, sr + 1, sc, newColor, srcColor);
        dfs(image, sr, sc - 1, newColor, srcColor);
        dfs(image, sr, sc + 1, newColor, srcColor);
    }
}
