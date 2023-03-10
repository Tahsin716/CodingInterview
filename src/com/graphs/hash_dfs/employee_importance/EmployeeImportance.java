package com.graphs.hash_dfs.employee_importance;

import java.util.HashMap;
import java.util.List;

public class EmployeeImportance {
    public int getImportance(List<Employee> employees, int id) {
        // Create a HashMap to store all employees by their id for O(1) lookup
        HashMap<Integer, Employee> map = new HashMap<>();

        // Fill the HashMap with all employees in the list
        for (Employee employee : employees)
            map.put(employee.id, employee);

        // Return the total importance value of the employee with the given id
        return dfs(map, id);
    }

    // DFS algorithm to traverse the hierarchical structure of the employees' subordinates
    private int dfs(HashMap<Integer, Employee> map, int id) {
        // Get the current employee from the HashMap
        Employee currentEmployee = map.get(id);
        // Initialize the total importance value with the importance value of the current employee
        int total = currentEmployee.importance;

        // Traverse the subordinates of the current employee using DFS
        for (int subordinateId : currentEmployee.subordinates)
            // Add the importance value of each subordinate to the total importance value
            total += dfs(map, subordinateId);

        // Return the total importance value
        return total;
    }

    private class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    };
}

