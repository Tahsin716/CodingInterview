package com.graphs.topological_sort.alien_dictionary;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class AlienDictionary {
    private Set<Integer>[] graph;
    private int[] indegree;
    private Set<Integer> seen;
    private final int TOTAL_CHARACTERS = 26;

    public String alienOrder(String[] words) {
        buildGraph(words);

        // If the graph is invalid, return an empty string.
        if (graph == null) return "";

        // Create a queue to store nodes with zero incoming edges, and a StringBuilder to store the final result.
        //
        // Using PriorityQueue ensures that nodes are added to the queue in order of increasing indegree,
        // which is necessary for the topological sorting algorithm to work correctly.
        Queue<Integer> queue = new PriorityQueue<>();
        StringBuilder builder = new StringBuilder();

        // Add all nodes with zero incoming edges to the queue.
        for (int i = 0; i < TOTAL_CHARACTERS; i++) {
            if (seen.contains(i) && indegree[i] == 0) queue.offer(i);
        }

        // Perform topological sorting using the queue, adding nodes to the StringBuilder as they are visited.
        while (!queue.isEmpty()) {
            int u = queue.poll();
            builder.append((char)('a' + u));

            for (int v : graph[u]) {
                indegree[v]--;

                if (indegree[v] == 0) queue.offer(v);
            }
        }

        // If the StringBuilder contains all nodes, return the result. Otherwise, return an empty string.
        return builder.length() == seen.size() ? builder.toString() : "";
    }

    // Builds the graph and updates the indegree of each node.
    private void buildGraph(String[] words) {
        graph = new HashSet[TOTAL_CHARACTERS];
        indegree = new int[TOTAL_CHARACTERS];
        seen = new HashSet<>();

        for (int i = 0; i < TOTAL_CHARACTERS; i++) {
            graph[i] = new HashSet<>();
        }

        // Iterate through each adjacent word pair and add edges to the graph as appropriate.
        for (int i = 0; i < words.length - 1; i++) {
            String word1 = words[i];
            String word2 = words[i + 1];

            int word1Pointer = 0, word2Pointer = 0;
            boolean isPrefix = true;

            // Compare each character in the words until a difference is found, and add an edge between the characters.
            while (word1Pointer < word1.length() && word2Pointer < word2.length()) {
                int u = word1.charAt(word1Pointer) - 'a';
                int v = word2.charAt(word2Pointer) - 'a';

                // If an edge already exists, break out of the loop.
                if (graph[u].contains(v)) break;

                // If the characters are different, add an edge and update the indegree of the target node.
                if (u != v) {
                    graph[u].add(v);
                    indegree[v]++;
                    isPrefix = false;
                    break;
                }

                // If the characters are the same, add them to the set of seen nodes and continue iterating.
                seen.add(u);
                seen.add(v);

                word1Pointer++;
                word2Pointer++;
            }

            // If word1 is a prefix of word2 but word1 is longer, the ordering is invalid.
            if (isPrefix && word1Pointer < word1.length() && word2Pointer >= word2.length()) {
                graph = null;
                return;
            }

            // Add any remaining characters to the set of seen nodes.
            while (word1Pointer < word1.length()) {
                int u = word1.charAt(word1Pointer) - 'a';
                seen.add(u);
                word1Pointer++;
            }

            // Add any remaining characters to the set of seen nodes.
            while (word2Pointer < word2.length()) {
                int v = word2.charAt(word2Pointer) - 'a';
                seen.add(v);
                word2Pointer++;
            }
        }
    }
}
