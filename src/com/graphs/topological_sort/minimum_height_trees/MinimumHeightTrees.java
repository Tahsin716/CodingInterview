package com.graphs.topological_sort.minimum_height_trees;

import java.util.*;

public class MinimumHeightTrees {
    Set<Integer>[] graph; // adjacency list representing the graph

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        // if there's only one node, it is the root of the only tree
        if (n == 1) return List.of(0);

        // build the adjacency list graph
        buildGraph(n, edges);
        Queue<Integer> queue = new LinkedList<>();

        // Add all the leaves to the queue
        for (int i = 0; i < n; i++) {
            if (graph[i].size() == 1) queue.offer(i);
        }

        int remainingNodes = n, numberOfLeaves;

        // Keep removing leaves until there are 2 or fewer nodes left
        while (remainingNodes > 2) {
            numberOfLeaves = queue.size();
            remainingNodes -= numberOfLeaves;

            // Remove all the current leaves and add their neighbors to the queue if they become leaves
            for (int i = 0; i < numberOfLeaves; i++) {
                int leaf = queue.poll();
                int neighbour = graph[leaf].iterator().next();

                graph[neighbour].remove(leaf);

                if (graph[neighbour].size() == 1) queue.offer(neighbour);
            }
        }

        // Return the remaining nodes as roots of the minimum height trees
        return new ArrayList<>(queue);
    }

    // Builds the adjacency list graph from the input edges
    private void buildGraph(int n, int[][] edges) {
        graph = new HashSet[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new HashSet<Integer>();
        }

        for (int[] edge: edges) {
            int u = edge[1];
            int v = edge[0];

            graph[u].add(v);
            graph[v].add(u);
        }
    }
}

