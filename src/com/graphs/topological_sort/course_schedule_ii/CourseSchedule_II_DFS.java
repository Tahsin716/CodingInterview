package com.graphs.topological_sort.course_schedule_ii;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class CourseSchedule_II_DFS {
    // List of adjacency lists to represent the graph
    List<Integer>[] graph;
    // Stack to keep track of the topological order
    Stack<Integer> stack;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // Build the graph
        buildGraph(numCourses, prerequisites);
        // Initialize the stack
        stack = new Stack<>();

        // Array to keep track of visited nodes
        boolean[] visited = new boolean[numCourses];
        // Array to keep track of processed nodes
        boolean[] processed = new boolean[numCourses];

        // Traverse the graph in DFS fashion, starting from every unvisited node
        for (int i = 0; i < numCourses; i++) {
            if (!visited[i]) {
                // If a cycle is detected, return an empty array
                if (hasCycle(i, visited, processed)) {
                    return new int[]{};
                }
            }
        }

        // Create an array to hold the topological order
        int[] order = new int[stack.size()];
        int index = 0;

        // Pop elements off the stack and add them to the order array
        while (!stack.isEmpty()) {
            order[index++] = stack.pop();
        }

        // Return the topological order
        return order;
    }


    // Recursive function to detect cycles and perform DFS traversal
    private boolean hasCycle(int vertex, boolean[] visited, boolean[] processed) {
        visited[vertex] = true;

        // Traverse all neighbours of the current vertex
        for (int neighbour : graph[vertex]) {
            // If the neighbour is unvisited, perform DFS on it
            if (!visited[neighbour]) {
                if (hasCycle(neighbour, visited, processed)) {
                    return true;
                }
            } // If the neighbour is visited but not processed, it means there is a cycle
            else if (!processed[neighbour]) {
                return true;
            }
        }

        processed[vertex] = true;
        // Push the current vertex onto the stack after it has been processed
        stack.push(vertex);

        // Return false to indicate that no cycle was detected
        return false;
    }

    // Helper function to build the graph
    private void buildGraph(int numCourses, int[][] prerequisites) {
        graph = new ArrayList[numCourses];

        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }

        // Add edges to the graph
        for (int[] prerequisite : prerequisites) {
            int from = prerequisite[1];
            int to = prerequisite[0];

            graph[from].add(to);
        }
    }
}

