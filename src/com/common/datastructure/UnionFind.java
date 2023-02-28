package com.common.datastructure;

public class UnionFind {
    private int[] parent;
    private int[] size;
    private int count;

    public UnionFind(int n) {
        parent = new int[n];
        size = new int[n];
        count = n;

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    public int find(int node) {
        if (parent[node] != node) {
            parent[node] = find(parent[node]);
        }
        return parent[node];
    }

    public void union(int p1, int p2) {
        if (size[p1] < size[p2]) {
            int temp = p1;
            p1 = p2;
            p2 = temp;
        }
        parent[p2] = p1;
        size[p1] += size[p2];
        count--;
    }

    public int count() {
        return count;
    }
}