package com.graphs.shortest_time.time_needed_to_inform_all_employees;

import java.util.ArrayList;
import java.util.List;

public class TimeNeededToInformAllEmployees {
    List<Integer>[] graph; //declare a graph as a list of integer arrays

    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        if (n == 1) return 0; //base case, if there is only one employee, the time taken to inform will be 0

        buildGraph(n, manager); //build a graph from the manager array

        int time = dfs(headID, informTime); //perform dfs starting from the head of the graph and calculate the time required

        return time; //return the time taken
    }

    private int dfs(int u, int[] informTime) { //recursive function to perform dfs
        int cost = 0; //initialize the cost to be 0

        for (int v : graph[u]) { //loop through all the nodes that u is connected to
            cost = Math.max(cost, dfs(v, informTime)); //recursively perform dfs on each child node and update the cost
        }

        cost += informTime[u]; //add the time taken to inform the current employee

        return cost; //return the total cost
    }

    private void buildGraph(int n, int[] manager) { //function to build the graph
        graph = new ArrayList[n]; //initialize the graph with n vertices

        for (int i = 0; i < n; i++) { //loop through each vertex of the graph
            graph[i] = new ArrayList<>(); //initialize the adjacency list for each vertex
        }

        for (int i = 0; i < n; i++) { //loop through each employee
            if (manager[i] == -1) continue; //skip if the employee has no manager

            graph[manager[i]].add(i); //add the employee to the adjacency list of their manager
        }
    }
}
