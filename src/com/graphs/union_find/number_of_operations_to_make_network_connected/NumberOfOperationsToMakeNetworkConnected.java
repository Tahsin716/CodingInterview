package com.graphs.union_find.number_of_operations_to_make_network_connected;

import com.common.datastructure.UnionFind;

public class NumberOfOperationsToMakeNetworkConnected {
    public int makeConnected(int n, int[][] connections) {
        // If there are fewer edges than required to connect all nodes,
        // it's impossible to make all nodes connected, so return -1.
        if (connections.length < n - 1) {
            return -1;
        }

        // Create a UnionFind data structure to keep track of connected components.
        UnionFind unionFind = new UnionFind(n);

        // Loop through all the connections and union the nodes they connect.
        for (int[] connection : connections) {
            int p1 = unionFind.find(connection[0]);
            int p2 = unionFind.find(connection[1]);

            if (p1 != p2) {
                unionFind.union(p1, p2);
            }
        }

        // Return the number of connected components minus 1, which is the
        // minimum number of operations required to make all nodes connected.
        return unionFind.count() - 1;
    }
}
