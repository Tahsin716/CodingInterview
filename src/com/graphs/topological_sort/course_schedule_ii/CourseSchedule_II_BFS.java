package com.graphs.topological_sort.course_schedule_ii;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule_II_BFS {
    List<Integer>[] graph; // list of adjacent nodes for each node
    private int[] indegree; // array to store the indegree of each node

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        buildGraph(numCourses, prerequisites); // build graph and calculate indegree of each node
        Queue<Integer> queue = new LinkedList<>();

        // add nodes with zero indegree to the queue
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) queue.offer(i);
        }

        List<Integer> order = new ArrayList<>();

        // process nodes with zero indegree
        while (!queue.isEmpty()) {
            int u = queue.poll();
            order.add(u);

            // decrease the indegree of each adjacent node by one
            for (int v : graph[u]) {
                indegree[v]--;

                // if a node has zero indegree, add it to the queue
                if (indegree[v] == 0) queue.offer(v);
            }
        }

        // if all nodes have not been processed, there is a cycle and it's impossible to finish all courses
        if (order.size() != numCourses) return new int[]{};

        // convert the list of nodes to an array
        int[] result = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            result[i] = order.get(i);
        }

        return result;
    }

    private void buildGraph(int numCourses, int[][] prerequisites) {
        graph = new ArrayList[numCourses];
        indegree = new int[numCourses];

        // initialize the list of adjacent nodes for each node
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }

        // calculate the indegree of each node and add the edge to the graph
        for (int[] prerequisite: prerequisites) {
            int u = prerequisite[1];
            int v = prerequisite[0];

            graph[u].add(v);
            indegree[v]++;
        }
    }
}

