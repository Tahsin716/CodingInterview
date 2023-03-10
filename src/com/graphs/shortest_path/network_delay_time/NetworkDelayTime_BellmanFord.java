package com.graphs.shortest_path.network_delay_time;

import java.util.Arrays;

public class NetworkDelayTime_BellmanFord {
    public int networkDelayTime(int[][] times, int N, int K) {
        // Initialize an array to store the minimum distances from the source vertex K to all, other vertices
        int[] dist = new int[N];
        // Initialize all distances to infinity, except for the source vertex which is 0
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[K - 1] = 0;

        // Relax all edges N-1 times
        for (int i = 0; i < N - 1; i++) {
            // Loop through all edges in the times array
            for (int j = 0; j < times.length; j++) {
                int u = times[j][0];
                int v = times[j][1];
                int w = times[j][2];
                // If the distance to vertex u is not infinity and the distance to vertex v through u is less than the current distance to v,
                // update the distance to v
                if (dist[u - 1] != Integer.MAX_VALUE && dist[u - 1] + w < dist[v - 1]) {
                    dist[v - 1] = dist[u - 1] + w;
                }
            }
        }

        // Find the maximum distance from the source vertex to any other vertex
        int res = Arrays.stream(dist).skip(1).max().getAsInt();

        // If the maximum distance is still Integer.MAX_VALUE, it means there is no path from the source vertex to some other vertices
        // so return -1. Otherwise, return the maximum distance.
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}

