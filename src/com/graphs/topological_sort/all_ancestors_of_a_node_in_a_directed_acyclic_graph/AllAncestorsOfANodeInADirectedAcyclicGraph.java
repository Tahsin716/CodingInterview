package com.graphs.topological_sort.all_ancestors_of_a_node_in_a_directed_acyclic_graph;

import java.util.*;

public class AllAncestorsOfANodeInADirectedAcyclicGraph {
    // List of parents of each node
    private List<Integer>[] parents;
    // List of children of each node
    private List<Integer>[] graph;
    // Indegree of each node
    private int[] indegree;

    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        // Build the graph and initialize the list of ancestors for each node
        buildGraph(n, edges);
        List<Set<Integer>> ancestors = new ArrayList<>();

        // Initialize a queue with all nodes that have no parents
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (parents[i].size() == 0) {
                queue.offer(i);
            }
            // Initialize the list of ancestors for each node with an empty set
            ancestors.add(new TreeSet<>());
        }

        // BFS traversal to find all ancestors of each node
        while (!queue.isEmpty()) {
            int u = queue.poll();
            Set<Integer> currentNodeAncestor = ancestors.get(u);

            // For each parent of the current node, add all of its ancestors and the parent itself to the current node's ancestor list
            for (int parent : parents[u]) {
                Set<Integer> parentAncestors = ancestors.get(parent);

                for (int parentAncestor : parentAncestors) currentNodeAncestor.add(parentAncestor);

                currentNodeAncestor.add(parent);
            }

            // Decrement the indegree of all children of the current node and add them to the queue
            // if their indegree becomes zero
            for (int v : graph[u]) {
                indegree[v]--;
                if (indegree[v] == 0) queue.offer(v);
            }
        }

        // Convert the list of ancestor sets to a list of ancestor lists and return the result
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            result.add(new ArrayList<>(ancestors.get(i)));
        }
        return result;
    }

    // Build the graph and initialize the parents and indegree arrays
    private void buildGraph(int n, int[][] edges) {
        parents = new ArrayList[n];
        graph = new ArrayList[n];
        indegree = new int[n];

        for (int i = 0; i < n; i++) {
            parents[i] = new ArrayList<>();
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            // Add the edge to the graph and the parent to the parents list of the child
            graph[u].add(v);
            parents[v].add(u);

            // Increment the indegree of the child
            indegree[v]++;
        }
    }
}

