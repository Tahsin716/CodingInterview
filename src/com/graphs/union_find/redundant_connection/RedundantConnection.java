package com.graphs.union_find.redundant_connection;

import com.common.datastructure.UnionFind;

public class RedundantConnection {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;

        UnionFind unionFind = new UnionFind(n);
        int[] ans = new int[2];

        for (int[] edge : edges) {
            // Subtract by 1, to convert 1...n => 0...n - 1
            int u = edge[0] - 1;
            int v = edge[1] - 1;

            int root1 = unionFind.find(u);
            int root2 = unionFind.find(v);

            // If there is no connection, make a connection
            if (root1 != root2) {
                unionFind.union(root1, root2);
            } else {
                // if there exists a connection, store the edges
                ans[0] = edge[0];
                ans[1] = edge[1];
            }
        }

        return ans;
    }
}
