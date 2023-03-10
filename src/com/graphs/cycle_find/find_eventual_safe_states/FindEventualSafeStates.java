package com.graphs.cycle_find.find_eventual_safe_states;

import java.util.*;

public class FindEventualSafeStates {
    List<Integer>[] inVerticesGraph;  // adjacency list representation of the input graph where inVerticesGraph[i] contains a list of vertices that have an edge towards vertex i
    int[] outdegree;  // outdegree[i] is the number of outgoing edges from vertex i

    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        Queue<Integer> queue = new LinkedList<>();
        buildGraph(n, graph);  // build the adjacency list representation of the input graph

        for (int i = 0; i < n; i++) {  // add all vertices with outdegree 0 to the queue
            if (outdegree[i] == 0) queue.offer(i);
        }

        List<Integer> result = new ArrayList<>();  // list to store the eventual safe nodes

        while (!queue.isEmpty()) {  // breadth-first search
            int u = queue.poll();  // remove the first vertex from the queue
            result.add(u);  // add the vertex to the list of eventual safe nodes

            for (int v : inVerticesGraph[u]) {  // reduce the outdegree of all vertices that have an incoming edge from vertex u
                outdegree[v]--;

                if (outdegree[v] == 0) queue.offer(v);  // add vertex v to the queue if its outdegree becomes 0
            }
        }

        Collections.sort(result);  // sort the list of eventual safe nodes
        return result;  // return the list of eventual safe nodes
    }

    private void buildGraph(int n, int[][] graph) {  // helper function to build the adjacency list representation of the input graph
        inVerticesGraph = new ArrayList[n];
        outdegree = new int[n];

        for (int i = 0; i < n; i++) {
            inVerticesGraph[i] = new ArrayList<>();
            outdegree[i] = graph[i].length;
        }

        for (int i = 0; i < n; i++) {
            for (int v : graph[i]) {
                inVerticesGraph[v].add(i);
            }
        }
    }
}

