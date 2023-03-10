package com.graphs.shortest_path.network_delay_time;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class NetworkDelayTime_Dijkstra {
    // an array to store the distances from the source node to each node in the graph
    int[] distances;
    // a map to represent the graph
    Map<Integer, Map<Integer, Integer>> graph;

    public int networkDelayTime(int[][] times, int n, int k) {
        // build the graph from the given array of edges
        buildGraph(times);
        // find the shortest distances from the source node to all other nodes in the graph using Dijkstra's algorithm
        dijkstra(n, k);

        // get the maximum distance from the source node to any other node in the graph
        int maxDistance = Arrays.stream(distances).skip(1).max().getAsInt();

        // if there is a node that is unreachable from the source node, return -1; otherwise, return the maximum distance
        return maxDistance == Integer.MAX_VALUE ? -1 : maxDistance;
    }

    private void dijkstra(int nodes, int src) {
        // initialize the distances array with infinity for all nodes except the source node
        distances = new int[nodes + 1];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[src] = 0;

        // use a priority queue to keep track of the nodes to visit, with the node with the smallest distance from the source node at the top of the queue
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> distances[a] - distances[b]);
        queue.offer(src);

        while (!queue.isEmpty()) {
            // get the node with the smallest distance from the source node
            int u = queue.poll();

            // if the current node has neighbors, update the distances to the neighbors if the path through the current node is shorter than the previously calculated distance
            if (graph.containsKey(u)) {
                for (int v : graph.get(u).keySet()) {
                    int w = graph.get(u).get(v); // get the weight of the edge from u to v
                    int distance = distances[u] + w; // calculate the total distance from the source node to v through u

                    // if the new distance to v is shorter than the previously calculated distance, update the distances array and add v to the queue to be processed later
                    if (distance < distances[v]) {
                        distances[v] = distance;
                        queue.offer(v);
                    }
                }
            }
        }
    }

    private void buildGraph(int[][] times) {
        // initialize the graph as a map from node numbers to maps of neighbors and their edge weights
        graph = new HashMap<>();

        // iterate through the array of edges and add each edge to the graph
        for (int[] time : times) {
            int u = time[0];
            int v = time[1];
            int w = time[2];

            graph.putIfAbsent(u, new HashMap<>());
            graph.get(u).put(v, w);
        }
    }
}

