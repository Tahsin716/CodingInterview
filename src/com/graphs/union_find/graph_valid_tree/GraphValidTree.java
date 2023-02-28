package com.graphs.union_find.graph_valid_tree;

import java.util.ArrayList;
import java.util.List;

public class GraphValidTree {
    private List<Integer>[] graph;

    public boolean validTree(int n, int[][] edges) {
        // If the number of edges is not exactly one less than the number of nodes, it cannot be a tree
        if (edges.length != n - 1) {
            return false;
        }

        // Build the graph using the edges provided
        buildGraph(n, edges);

        // Check if the graph has a cycle by doing a depth-first traversal
        boolean[] visited = new boolean[n];

        // Start from node 0 and set its parent as -1
        if (hasCycle(0, -1, visited)) {
            return false;
        }

        // Check if the graph is a single, connected component
        return isConnectedComponent(visited);
    }

    // Function to check if the graph has a cycle by doing a depth-first traversal
    private boolean hasCycle(int vertex, int parent, boolean[] visited) {
        visited[vertex] = true;

        // Visit all the neighbors of the current vertex
        for (int neighbour : graph[vertex]) {
            if (!visited[neighbour]) {
                // If a cycle is found, return true
                if (hasCycle(neighbour, vertex, visited)) {
                    return true;
                }
            } // If the neighbor has been visited before, and it is not the parent, it means a cycle is present
            else if (neighbour != parent) {
                return true;
            }
        }

        // If all neighbors have been visited and no cycle is found, return false
        return false;
    }

    private boolean isConnectedComponent(boolean[] visited) {
        // If any node is not connected to the root node, return false
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) return false;
        }
        return true;
    }

    private void buildGraph(int n, int[][] edges) {
        graph = new ArrayList[n];

        // Initialize each element of the adjacency list to an empty ArrayList
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        // Add each edge to the adjacency list of its two nodes
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            graph[u].add(v);
            graph[v].add(u);
        }
    }
}
