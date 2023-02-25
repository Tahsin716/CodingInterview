package com.graphs.topological_sort.course_schedule;

import java.util.ArrayList;
import java.util.List;

public class CourseSchedule_DFS {
    // declare an instance variable to store the graph
    private List<Integer>[] graph;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // build the graph from prerequisites
        buildGraph(numCourses, prerequisites);

        // create a boolean array to track visited vertices
        boolean[] visited = new boolean[numCourses];
        // create a boolean array to track processed vertices
        boolean[] processed = new boolean[numCourses];

        // iterate over each vertex in the graph
        for (int i = 0; i < numCourses; i++) {
            // if the vertex has a cycle, return false
            if (hasCycle(i, visited, processed)) {
                return false;
            }
        }

        // if no cycles found in the graph, return true
        return true;
    }

    // depth-first search function to detect cycles
    private boolean hasCycle(int vertex, boolean[] visited, boolean[] processed) {
        // mark the vertex as visited
        visited[vertex] = true;

        // iterate over the neighbors of the vertex
        for (int neighbour : graph[vertex]) {
            // if the neighbor is not yet visited, recursively search it
            if (!visited[neighbour]) {
                // if the neighbor has a cycle, return true
                if (hasCycle(neighbour, visited, processed)) {
                    return true;
                }
            } // if the neighbor is visited but not yet processed, there is a cycle
            else if (!processed[neighbour]) {
                return true;
            }
        }

        // mark the vertex as processed
        processed[vertex] = true;
        // return false if no cycle is found
        return false;
    }

    private void buildGraph(int numCourses, int[][] prerequisites) {
        // create an array of ArrayLists to store the adjacency list of each vertex
        graph = new ArrayList[numCourses];

        // initialize each ArrayList in the graph
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }

        // iterate over each prerequisite
        for (int[] prerequisite: prerequisites) {
            int from = prerequisite[1]; // the prerequisite is from course "from"
            int to = prerequisite[0]; // to course "to"

            graph[from].add(to); // add an edge from "from" to "to"
        }
    }
}

