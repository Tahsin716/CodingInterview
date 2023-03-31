package com.greedy.restore_the_array_from_adjacent_pairs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RestoreTheArrayFromAdjacentPairs {
    // Adjacency list representing the graph of elements and their adjacent pairs
    private Map<Integer, List<Integer>> graph;

    public int[] restoreArray(int[][] adjacentPairs) {
        // Build the adjacency list graph
        buildGraph(adjacentPairs);

        int start = 0;

        // Find the starting element with only one adjacent pair
        for (int key : graph.keySet()) {
            if (graph.get(key).size() == 1) {
                start = key;
                break;
            }
        }

        // Initialize the array with the start element
        int[] result = new int[adjacentPairs.length + 1];
        result[0] = start;

        // Traverse the graph and build the array
        for (int i = 1; i < result.length; i++) {
            int previousNum = result[i - 1], currentNum;

            // Get the adjacent pairs of the previous element
            List<Integer> adjacentList = graph.get(previousNum);

            // If the previous element has only one adjacent element, choose it
            if (adjacentList.size() == 1) {
                currentNum = adjacentList.get(0);
            } else {
                // If the previous element has two adjacent elements, choose the correct one
                // if the first adjacent element is not the previous element, then first element
                // otherwise the second element
                currentNum = adjacentList.get(0) == result[i - 2] ? adjacentList.get(1) : adjacentList.get(0);
            }

            result[i] = currentNum;
        }

        return result;
    }

    // Build the adjacency list graph
    private void buildGraph(int[][] edges) {
        graph = new HashMap<>();

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            graph.putIfAbsent(u, new ArrayList<>());
            graph.putIfAbsent(v, new ArrayList<>());

            graph.get(u).add(v);
            graph.get(v).add(u);
        }
    }
}
