package com.backtracking.all_paths_from_source_to_target;

import java.util.ArrayList;
import java.util.List;

public class AllPathsFromSourceToTarget {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int n = graph.length; // number of nodes in the graph
        List<List<Integer>> result = new ArrayList<>(); // stores all the paths
        List<Integer> list = new ArrayList<>(); // stores a single path

        list.add(0); // add the source node to the path
        backtrack(0, n, graph, result, list); // start the backtracking algorithm

        return result; // return all the paths
    }

    // recursive function that performs the backtracking algorithm
    private void backtrack(int u, int n, int[][] graph, List<List<Integer>> result, List<Integer> list) {
        if (u == n - 1) { // if the target node is reached
            result.add(new ArrayList<>(list)); // add the current path to the result list
            return; // backtrack to the previous node
        }

        for (int v: graph[u]) { // for all the adjacent nodes of u
            list.add(v); // add the current node to the path
            backtrack(v, n, graph, result, list); // recursively explore the path from the current node
            list.remove(list.size() - 1); // remove the current node from the path to backtrack
        }
    }
}

