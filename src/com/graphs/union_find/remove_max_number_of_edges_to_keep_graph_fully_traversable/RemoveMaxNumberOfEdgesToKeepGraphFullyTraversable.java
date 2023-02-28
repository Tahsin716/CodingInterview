package com.graphs.union_find.remove_max_number_of_edges_to_keep_graph_fully_traversable;

import java.util.Arrays;

public class RemoveMaxNumberOfEdgesToKeepGraphFullyTraversable {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        // Sort edges in decreasing order of type to prioritize type 3 edges.
        Arrays.sort(edges, (current, next) -> next[0] - current[0]);

        // Create UnionFind data structures for Alice and Bob.
        UnionFind alice = new UnionFind(n);
        UnionFind bob = new UnionFind(n);

        int edgesCount = 0; // Count of edges to be removed.

        // Iterate through edges and remove them based on type.
        for (int[] edge : edges) {
            int type = edge[0];
            int u = edge[1] - 1; // 0-index the nodes.
            int v = edge[2] - 1;

            switch (type) {
                case 3:
                    // If the edge connects two components of either Alice or Bob,
                    // it doesn't need to be removed.
                    if (alice.unite(u, v) | bob.unite(u, v)) {
                        edgesCount++;
                    }
                    break;
                case 2:
                    // If the edge connects two components of Bob, it doesn't need to be removed.
                    if (bob.unite(u, v)) {
                        edgesCount++;
                    }
                    break;
                case 1:
                    // If the edge connects two components of Alice, it doesn't need to be removed.
                    if (alice.unite(u, v)) {
                        edgesCount++;
                    }
                    break;
            }
        }

        // If there is more than one connected component for either Alice or Bob,
        // the graph cannot be fully traversed.
        if (alice.count() != 1 || bob.count() != 1) {
            return -1;
        }

        // Return the number of edges that were removed.
        return edges.length - edgesCount;
    }

    private class UnionFind {
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
                int temp = p2;
                p2 = p1;
                p1 = temp;
            }
            parent[p2] = p1;
            size[p1] += size[p2];
            count--;
        }

        public boolean unite(int p1, int p2) {
            int root1 = find(p1);
            int root2 = find(p2);

            if (root1 != root2) {
                union(root1, root2);
                return true;
            }

            return false;
        }

        public int count() {
            return count;
        }
    }
}
