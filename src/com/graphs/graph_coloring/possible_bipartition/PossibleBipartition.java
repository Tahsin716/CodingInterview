package com.graphs.graph_coloring.possible_bipartition;

import java.util.ArrayList;
import java.util.List;

public class PossibleBipartition {
    // Declaring variables used in the class
    List<Integer>[] graph; // A list of integers representing the graph
    int[] colors; // An array of integers to store the colors assigned to each node

    // The method to determine whether it's possible to form two groups based on the dislikes
    public boolean possibleBipartition(int n, int[][] dislikes) {
        // Build the graph using the dislikes array
        buildGraph(n, dislikes);

        // Initialize the colors array to all zeros
        colors = new int[n];

        // Traverse through all the nodes and check if they belong to a valid group
        for (int i = 0; i < n; i++) {
            // If a node is not assigned a color and cannot be assigned one, return false
            if (colors[i] == 0 && !dfs(i, 1)) {
                return false;
            }
        }

        // If all nodes have been assigned a color, return true
        return true;
    }

    // Helper method to perform depth-first search
    private boolean dfs(int u, int color) {
        // Assign a color to the current node
        colors[u] = color;

        // Traverse through all the nodes adjacent to the current node
        for (int v : graph[u]) {
            // If the adjacent node has the same color as the current node, return false
            if (colors[v] == color) {
                return false;
            }
            // If the adjacent node has not been assigned a color, recursively assign it the opposite color
            if (colors[v] == 0 && !dfs(v, -color)) {
                return false;
            }
        }

        // If all adjacent nodes have been traversed without any conflict, return true
        return true;
    }

    // Helper method to build the graph
    private void buildGraph(int n, int[][] dislikes) {
        graph = new ArrayList[n];

        // Initialize each node of the graph with an empty ArrayList
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        // Add edges between nodes based on the dislikes array
        for (int[] edge : dislikes) {
            int u = edge[0] - 1;
            int v = edge[1] - 1;

            graph[u].add(v);
            graph[v].add(u);
        }
    }
}

