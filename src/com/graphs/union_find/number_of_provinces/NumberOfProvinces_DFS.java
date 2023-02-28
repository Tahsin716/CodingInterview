package com.graphs.union_find.number_of_provinces;

public class NumberOfProvinces_DFS {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;   // get the number of cities in the matrix
        boolean[] visited = new boolean[n];   // keep track of visited cities
        int count = 0;   // count the number of provinces found so far

        for (int i = 0; i < n; i++) {
            // if the current city has not been visited
            if (!visited[i]) {
                dfs(i, isConnected, visited); // perform DFS on this city and its connected cities
                count++; // increment the number of provinces found
            }
        }

        // return the number of provinces found
        return count;
    }

    private void dfs(int i, int[][] isConnected, boolean[] visited) {
        visited[i] = true;   // mark the current city as visited

        for (int j = 0; j < isConnected.length; j++) {
            // if there is a connection between the current city
            // and another city and the other city has not been visited
            if (isConnected[i][j] == 1 && !visited[j]) {
                // perform DFS on the other city and its connected cities
                dfs(j, isConnected, visited);
            }
        }
    }
}

