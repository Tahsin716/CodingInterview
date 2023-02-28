package com.graphs.union_find.number_of_provinces;

import com.common.datastructure.UnionFind;

public class NumberOfProvinces {
    public int findCircleNum(int[][] isConnected) {
        // Get the number of cities in the matrix
        int n = isConnected.length;

        // Initialize union find
        UnionFind unionFind = new UnionFind(n);

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                // If there is a connection between the city
                if (isConnected[i][j] == 1) {
                    int p1 = unionFind.find(i);
                    int p2 = unionFind.find(j);

                    // If there is no union between the cities, create a union
                    if (p1 != p2) {
                        unionFind.union(p1, p2);
                    }
                }
            }
        }

        // the number of connected component equals the number of provinces
        return unionFind.count();
    }
}
