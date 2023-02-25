package com.graphs.topological_sort.course_schedule;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule_BFS {
    // Declare an array of lists to represent the graph
    private List<Integer>[] graph;
    // Declare an array to keep track of the indegrees of each vertex
    private int[] indegree;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        buildGraph(numCourses, prerequisites); // Build the graph and calculate the indegrees
        Queue<Integer> queue = new LinkedList<>(); // Declare a queue to hold vertices with indegree 0

        // Add vertices with indegree 0 to the queue
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) queue.offer(i);
        }

        // Declare a list to hold the order of vertices in the topological sort
        List<Integer> order = new ArrayList<>();

        while (!queue.isEmpty()) {
            // Remove a vertex with indegree 0 from the queue
            int u = queue.poll();
            // Add the vertex to the order list
            order.add(u);

            for (int v : graph[u]) {
                // Decrement the indegrees of all adjacent vertices
                indegree[v]--;

                // If the indegree of a vertex becomes 0, add it to the queue
                if (indegree[v] == 0) queue.offer(v);
            }
        }

        // Return true if all vertices were added to the order list (i.e. the graph is a DAG)
        return order.size() == numCourses;
    }

    private void buildGraph(int numCourses, int[][] prerequisites) {
        graph = new ArrayList[numCourses]; // Initialize the graph array
        indegree = new int[numCourses]; // Initialize the indegree array

        // Initialize the adjacency list for each vertex
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] prerequisite: prerequisites) {
            int u = prerequisite[1];
            int v = prerequisite[0];

            graph[u].add(v);
            indegree[v]++;
        }
    }
}

