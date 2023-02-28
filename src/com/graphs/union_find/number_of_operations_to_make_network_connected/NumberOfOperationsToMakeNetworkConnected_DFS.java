package com.graphs.union_find.number_of_operations_to_make_network_connected;

import java.util.ArrayList;
import java.util.List;

public class NumberOfOperationsToMakeNetworkConnected_DFS {
    public int makeConnected(int n, int[][] connections) {
        // If the number of connections is less than n - 1, it is impossible to connect all computers, so return -1.
        if (connections.length < n - 1) {
            return -1;
        }

        // Build the graph based on the connections.
        List<Integer>[] graph = buildGraph(n, connections);

        // Count the number of connected components in the graph.
        int numComponents = countConnectedComponents(n, graph);

        // If there are k connected components, we need k-1 cables to connect all of them.
        return numComponents - 1;
    }

    // This method builds an adjacency list representing the graph.
    private List<Integer>[] buildGraph(int n, int[][] connections) {
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        // Iterate over each connection and add edges to the adjacency list.
        for (int[] connection : connections) {
            int a = connection[0];
            int b = connection[1];
            graph[a].add(b);
            graph[b].add(a);
        }

        return graph;
    }

    // This method counts the number of connected components in the graph.
    private int countConnectedComponents(int n, List<Integer>[] graph) {
        boolean[] visited = new boolean[n];
        int count = 0;

        // Iterate over each node, and if it hasn't been visited before, do a depth-first search to find all nodes in the component.
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, visited, graph);
                count++;
            }
        }

        return count;
    }

    // This method performs a depth-first search starting at the specified node.
    private void dfs(int node, boolean[] visited, List<Integer>[] graph) {
        visited[node] = true;

        // Recursively visit each unvisited neighbor of the current node.
        for (int neighbor : graph[node]) {
            if (!visited[neighbor]) {
                dfs(neighbor, visited, graph);
            }
        }
    }
}

