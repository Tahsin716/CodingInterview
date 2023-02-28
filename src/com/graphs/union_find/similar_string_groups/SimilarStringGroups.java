package com.graphs.union_find.similar_string_groups;

public class SimilarStringGroups {
    public int numSimilarGroups(String[] strs) {
        int n = strs.length;

        UnionFind unionFind = new UnionFind(n);

        // loop through all pairs of strings and check if they are similar
        // if so, unite the corresponding nodes in the UnionFind data structure
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isSimilar(strs[i], strs[j])) {
                    unionFind.unite(i, j);
                }
            }
        }

        // return the number of connected components in the UnionFind data structure
        return unionFind.count();
    }

    // checks if two strings are similar by comparing their characters
    // returns true if the strings are similar, false otherwise
    private boolean isSimilar(String str1, String str2) {
        int diffCount = 0, n = str1.length();

        for (int i = 0; i < n; i++) {
            if (str1.charAt(i) != str2.charAt(i)) diffCount++;

            // If the difference in both string is more than 2 characters, return false
            // as they are not similar
            if (diffCount > 2) return false;
        }

        return true;
    }

    private class UnionFind {
        private int[] parent;
        private int[] size;
        private int count;

        // initializes a UnionFind data structure with n nodes
        public UnionFind(int n) {
            parent = new int[n];
            size = new int[n];
            count = n;

            // each node is initially its own parent and has size 1
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        // recursively finds the parent of a node and performs path compression
        public int find(int node) {
            if (parent[node] != node) {
                parent[node] = find(parent[node]);
            }
            return parent[node];
        }

        // unites two nodes by setting the parent of one to the other
        // also updates the size of the parent node and the count of nodes
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

        // unites two nodes if they are not already in the same connected component
        public void unite(int p1, int p2) {
            int root1 = find(p1);
            int root2 = find(p2);

            if (root1 != root2) {
                union(root1, root2);
            }
        }

        // returns the number of connected components in the UnionFind data structure
        public int count() {
            return count;
        }
    }
}

