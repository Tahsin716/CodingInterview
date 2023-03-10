package com.graphs.graph_coloring.is_graph_bipartite;

import java.util.ArrayList;
import java.util.List;

public class IsGraphBipartite {
    List<Integer>[] graph; // Array of lists to represent the graph
    int[] colors; // Array to store the colors of each vertex

    public boolean isBipartite(int[][] edges) {
        int n = edges.length; // Number of vertices
        buildGraph(n, edges); // Build the graph using the given edges

        colors = new int[n]; // Initialize the colors array to all 0s

        for (int i = 0; i < n; i++) {
            if (colors[i] == 0 && !dfs(i, 1)) { // If the vertex is uncolored and cannot be colored, return false
                return false;
            }
        }

        return true; // Otherwise, return true
    }

    private boolean dfs(int u, int color) {
        colors[u] = color; // Color the current vertex with the given color

        for (int v : graph[u]) { // Iterate over all the neighbors of the current vertex
            if (colors[v] == color) { // If the neighbor has the same color as the current vertex, the graph is not bipartite
                return false;
            }

            if (colors[v] == 0 && !dfs(v, -color)) { // If the neighbor is uncolored, color it with the opposite color and perform DFS on it
                return false;
            }
        }

        return true; // If all neighbors can be colored, return true
    }

    private void buildGraph(int n, int[][] edges) {
        graph = new ArrayList[n]; // Initialize the array of lists to represent the graph

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>(); // Initialize an empty list for each vertex
        }

        for (int u = 0; u < n; u++) { // Iterate over all vertices
            for (int v : edges[u]) { // Iterate over all neighbors of the current vertex
                graph[u].add(v); // Add the neighbor to the list of neighbors for the current vertex
                graph[v].add(u); // Add the current vertex to the list of neighbors for the neighbor
            }
        }
    }
}

