package com.common.algorithms;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Dijkstra {

    public void dijkstra(List<int[]>[] graph, int nodes, int src) {
        // initialize the distances array with infinity for all nodes except the source node
        int[] distances = new int[nodes];
        Arrays.fill(distances, Integer.MAX_VALUE);

        // use a priority queue to keep track of the nodes to visit, with the node with the smallest distance from the source node at the top of the queue
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(a -> distances[a]));

        // Distance from source node to itself is 0
        distances[src] = 0;
        queue.offer(src);

        while (!queue.isEmpty()) {
            int u = queue.poll();

            for (int[] neighbour : graph[u]) { // for each neighbor of u
                int v = neighbour[0]; // get the neighbouring node
                int w = neighbour[1]; // get the weight of the edge from u to v
                int distance = distances[u] + w; // compute the distance from src to v through u

                if (distance < distances[v]) { // if we found a shorter path to v
                    distances[v] = distance; // update the shortest distance
                    queue.offer(v); // add v to the queue to explore its neighbors later
                }
            }
        }
    }
}
