package com.common.algorithms;

import java.util.Arrays;

public class BellmanFord {
    public void bellmanFord(int[][] edges, int n, int k) throws IllegalAccessException {
        // Initialize an array to store the minimum distances from the source vertex k to all, other vertices
        int[] distances = new int[n];
        // Initialize all distances to infinity, except for the source vertex which is 0
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[k] = 0;

        // Relax all edges n-1 edges
        for (int i = 0; i < n - 1; i++) {
            // Loop through all edges in the edges array
            for (int j = 0; j < edges.length; j++) {
                int u = edges[j][0];
                int v = edges[j][1];
                int w = edges[j][2];
                // If the distance to vertex u is not infinity and the distance to vertex v through u is less than the current distance to v,
                // update the distance to v
                if (distances[u] != Integer.MAX_VALUE && distances[u] + w < distances[v]) {
                    distances[v] = distances[u] + w;
                }
            }
        }

        // detect negative cycle
        // if value changes then we have a negative cycle in the graph,
        // and we cannot find the shortest distances
        for (int j = 0; j < edges.length; j++) {
            int u = edges[j][0];
            int v = edges[j][1];
            int w = edges[j][2];
            // If the distance decreased that means there is a negative cycle
            if (distances[u] != Integer.MAX_VALUE && distances[u] + w < distances[v]) {
                throw new IllegalAccessException("There is a negative cycle as the distance decreased");
            }
        }
    }
}
