package com.graphs.hash_dfs.keys_and_rooms;

import java.util.HashSet;
import java.util.List;

public class KeysAndRooms {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        // Create a set to store visited rooms
        HashSet<Integer> visited = new HashSet<>();

        // Call the DFS function starting from room 0
        dfs(0, rooms, visited);

        // Return true if all rooms are visited, false otherwise
        return visited.size() == rooms.size();
    }

    // This function implements the DFS algorithm
    private void dfs(int key, List<List<Integer>> rooms, HashSet<Integer> visited) {
        // Mark the current room as visited
        visited.add(key);

        // Get the keys available in the current room
        List<Integer> keys = rooms.get(key);

        // Iterate through all the keys
        for (int currentKey : keys) {
            // If the key leads to an unvisited room, call the DFS function for that room
            if (!visited.contains(currentKey)) {
                dfs(currentKey, rooms, visited);
            }
        }
    }
}
