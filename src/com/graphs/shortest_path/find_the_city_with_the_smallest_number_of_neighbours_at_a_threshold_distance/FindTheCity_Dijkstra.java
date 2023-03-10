package com.graphs.shortest_path.find_the_city_with_the_smallest_number_of_neighbours_at_a_threshold_distance;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class FindTheCity_Dijkstra {
    Map<Integer, Map<Integer, Integer>> graph; // adjacency list representation of the graph
    int[] distances; // shortest distances from source to all, other nodes

    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        buildGraph(edges); // create the adjacency list representation of the graph
        int city = -1, neighbourCount = n + 1, count = 0;

        // try each node as the source and compute the number of reachable neighbors
        for (int i = 0; i < n; i++) {
            dijkstra(n, i); // find the shortest paths from i to all, other nodes
            count = 0;

            // count the number of nodes that are within the threshold distance of i
            for (int j = 0; j < n; j++) {
                if (i == j) continue; // skip the node itself

                if (distances[j] <= distanceThreshold) count++;
            }

            // update the result if the number of reachable neighbors is smaller
            if (count <= neighbourCount) {
                city = i;
                neighbourCount = count;
            }
        }

        return city;
    }

    // Dijkstra's algorithm to find the shortest paths from a given source to all, other nodes
    private void dijkstra(int nodes, int src) {
        distances = new int[nodes];
        Arrays.fill(distances, Integer.MAX_VALUE);

        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> distances[a] - distances[b]);

        distances[src] = 0;
        queue.offer(src);

        while (!queue.isEmpty()) {
            int u = queue.poll();

            if (graph.containsKey(u)) { // check if u has any outgoing edges
                for (int v : graph.get(u).keySet()) { // for each neighbor of u
                    int w = graph.get(u).get(v); // get the weight of the edge from u to v
                    int distance = distances[u] + w; // compute the distance from src to v through u

                    if (distance < distances[v]) { // if we found a shorter path to v
                        distances[v] = distance; // update the shortest distance
                        queue.offer(v); // add v to the queue to explore its neighbors later
                    }
                }
            }
        }
    }

    // create the adjacency list representation of the graph
    private void buildGraph(int[][] edges) {
        graph = new HashMap<>();

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            graph.putIfAbsent(u, new HashMap<>());
            graph.putIfAbsent(v, new HashMap<>());

            graph.get(u).put(v, w);
            graph.get(v).put(u, w); // add the edge in both directions
        }
    }
}

