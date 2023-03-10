package com.graphs.shortest_path.network_delay_time;

public class NetworkDelayTime_FloydWarshall {
    public int networkDelayTime(int[][] times, int N, int K) {
        // use a 2D array to represent the graph and initialize it with max values
        int[][] graph = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                graph[i][j] = i == j ? 0 : Integer.MAX_VALUE;
            }
        }

        // Vertices in this problem start with 1
        // Add edges to the graph based on the input times array
        for (int i = 0; i < times.length; i++) {
            graph[times[i][0] - 1][times[i][1] - 1] = times[i][2];
        }

        // Floyd-Warshall algorithm to calculate the shortest path between all pairs of vertices
        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (graph[i][k] != Integer.MAX_VALUE && graph[k][j] != Integer.MAX_VALUE) {
                        graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                    }
                }
            }
        }

        // Find the maximum distance from the source vertex K to any other vertex
        int res = 0;
        for (int i = 0; i < N; i++) {
            res = Math.max(res, graph[K-1][i]);
        }

        // If the maximum distance is still Integer.MAX_VALUE, it means there is no path from the source vertex to some other vertices
        // so return -1. Otherwise, return the maximum distance.
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}
