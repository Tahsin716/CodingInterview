package com.graphs.hash_dfs.clone_graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CloneGraph {
    public Node cloneGraph(Node node) {
        // Create a HashMap to store the mapping between original nodes and cloned nodes
        HashMap<Node, Node> map = new HashMap<>();
        // Start DFS from the given node and return the cloned graph
        return dfs(node, map);
    }

    // Recursive function to perform DFS and clone the graph
    private Node dfs(Node node, HashMap<Node, Node> map) {
        if (node == null) return null; // Base case: if the given node is null, return null

        if (map.containsKey(node)) return map.get(node); // If the given node is already cloned, return its clone from the map

        // Otherwise, create a new node with the same value as the given node and add it to the map
        Node newNode = new Node(node.val);
        map.put(node, newNode);

        // Recursively clone the neighbors of the given node and add them to the new node's neighbors list
        for (Node neighbor : node.neighbors) {
            newNode.neighbors.add(dfs(neighbor, map));
        }

        // Return the cloned node
        return newNode;
    }

    // Definition for a Node.
    private class Node {
        public int val;
        public List<Node> neighbors; // List of neighboring nodes
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
}

