package com.graphs.shortest_path.find_the_city_with_the_smallest_number_of_neighbours_at_a_threshold_distance;

import java.util.Arrays;

public class FindTheCity_FloydWarshall {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        // Create a 2D array to store the shortest distance between any two cities
        int[][] distance = new int[n][n];
        int INF = 10000000; // A large value to represent infinity

        // Initialize the distance array with infinity and set the distance between a city and itself to 0
        for (int i = 0; i < n; i++) {
            Arrays.fill(distance[i], INF);
            distance[i][i] = 0;
        }

        // Add the edge distances to the distance array (since the graph is undirected, we add them in both directions)
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], w = edge[2];
            distance[u][v] = w;
            distance[v][u] = w;
        }

        // Use Floyd-Warshall algorithm to find the shortest distance between any two cities
        // Update the distance array by comparing the distance between two cities with the distance via an intermediate city
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    distance[i][j] = Math.min(distance[i][j], distance[i][k] + distance[k][j]);
                }
            }
        }

        // Find the city with the smallest number of neighbors at a threshold distance
        int minCities = n, minCity = -1;
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (distance[i][j] <= distanceThreshold) {
                    count++;
                }
            }
            if (count <= minCities) {
                minCities = count;
                minCity = i;
            }
        }

        return minCity;
    }
}

