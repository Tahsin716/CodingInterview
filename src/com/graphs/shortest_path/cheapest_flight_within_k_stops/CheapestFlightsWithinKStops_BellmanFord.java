package com.graphs.shortest_path.cheapest_flight_within_k_stops;

import java.util.Arrays;

public class CheapestFlightsWithinKStops_BellmanFord {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // Initialize an array to store the cost of reaching each node from the source node
        int[] cost = new int[n];
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[src] = 0;

        // Run the Bellman-Ford algorithm for k+1 iterations
        for (int i = 0; i <= k; i++) {
            // Create a copy of the cost array before each iteration
            int[] temp = Arrays.copyOf(cost, n);
            // Update the cost array for each flight
            for (int[] flight : flights) {
                int u = flight[0];
                int v = flight[1];
                int w = flight[2];

                // If the cost of the source node is not yet updated, skip this flight
                if (cost[u] == Integer.MAX_VALUE) continue;

                // If the cost of reaching node u plus the cost of the flight to node v is less than the current cost of reaching node v, update the cost of reaching node v
                if (cost[u] + w < temp[v]) {
                    temp[v] = cost[u] + w;
                }
            }
            // Update the cost array after each iteration
            cost = temp;
        }

        // Return the cost of reaching the destination node, or -1 if it is unreachable
        return cost[dst] == Integer.MAX_VALUE ? -1 : cost[dst];
    }
}

