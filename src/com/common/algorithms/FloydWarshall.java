package com.common.algorithms;

import java.util.Arrays;

public class FloydWarshall {
    // This function takes in an adjacency matrix and returns the shortest distances between every pair of vertices
    public int[][] floydWarshall(int[][] graph) {

        int n = graph.length; // n is the number of vertices in the graph

        int[][] dist = new int[n][n]; // dist[i][j] will be the shortest distance between vertex i and j

        // Initialize the distance array with infinity and set the distance between a node and itself to 0
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
            dist[i][i] = 0;
        }

        // Initialize dist with the values from the graph matrix
        for (int[] edge : graph) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            dist[u][v] = w;
        }

        // Perform Floyd-Warshall algorithm
        for (int k = 0; k < n; k++) { // Try all possible intermediate vertices
            for (int i = 0; i < n; i++) { // Try all possible starting vertices
                for (int j = 0; j < n; j++) { // Try all possible ending vertices
                    if (dist[i][k] != Integer.MAX_VALUE && dist[k][j] != Integer.MAX_VALUE && dist[i][k] + dist[k][j] < dist[i][j]) {
                        // If the path through k is shorter, update dist[i][j] to the new shorter distance
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        // Return the resulting shortest distances matrix
        return dist;
    }

}
