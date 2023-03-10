package com.graphs.shortest_path.cheapest_flight_within_k_stops;

import java.util.*;

public class CheapestFlightsWithinKStops_Dijkstra {
    List<int[]>[] graph; // graph represented as an adjacency list
    int minCost = -1; // minimum cost from source to destination

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        buildGraph(n, flights); // build the graph from the given flights
        dijkstra(n, src, dst, k); // run Dijkstra's algorithm

        return minCost; // return the minimum cost from source to destination
    }

    // Dijkstra's algorithm for finding the shortest path from source to destination with at most k stops
    private void dijkstra(int n, int src, int destination, int k) {
        int[] costs = new int[n];
        Arrays.fill(costs, Integer.MAX_VALUE); // initially set all costs to infinity

        // use a priority queue to keep track of the vertices to visit
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        costs[src] = 0; // cost from source to source is 0
        queue.offer(new int[]{0, src, k + 1}); // add the source vertex to the queue with 0 cost and k+1 stops left

        while (!queue.isEmpty()) {
            int[] current = queue.poll(); // get the vertex with the minimum cost
            int totalCost = current[0];
            int currentCity = current[1];
            int stopsLeft = current[2];

            if (currentCity == destination) { // if the destination is reached
                minCost = totalCost; // update the minimum cost and break out of the loop
                break;
            }

            if (stopsLeft == 0) continue; // if no more stops are allowed, continue to the next vertex

            for (int[] neighbours : graph[currentCity]) { // for each neighbour of the current vertex
                int city = neighbours[0];
                int costToNeighbour = neighbours[1];
                int newCost = totalCost + costToNeighbour; // calculate the new cost to reach the neighbour

                // We always update the cost to neighbour because the algorithm is always trying to find the shortest path from the source to the destination node
                // and if a cheaper path is found to a neighbour, it needs to be recorded.
                costs[city] = newCost; // update the cost of the neighbour

                // add the neighbour to the queue with the new cost and k-1 stops left
                queue.offer(new int[]{newCost, city, stopsLeft - 1});
            }
        }
    }

    // build the graph from the given flights
    private void buildGraph(int n, int[][] flights) {
        graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] flight : flights) {
            int u = flight[0];
            int v = flight[1];
            int w = flight[2];

            graph[u].add(new int[]{v, w}); // add an edge from u to v with weight w
        }
    }
}

