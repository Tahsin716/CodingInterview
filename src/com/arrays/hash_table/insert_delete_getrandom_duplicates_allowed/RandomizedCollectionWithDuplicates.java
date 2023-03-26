package com.arrays.hash_table.insert_delete_getrandom_duplicates_allowed;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

class RandomizedCollection {
    // Declare instance variables
    List<Integer> list; // Store the elements
    HashMap<Integer, HashSet<Integer>> map; // Map an element to its indices in list
    java.util.Random random; // Generate random integers

    public RandomizedCollection() {
        // Initialize the instance variables
        list = new ArrayList<>();
        map = new HashMap<>();
        random = new java.util.Random();
    }

    public boolean insert(int val) {
        boolean keyExists = map.containsKey(val); // Check if the value exists in the map

        if (!keyExists) { // If it doesn't exist
            map.put(val, new HashSet<Integer>()); // Create a new hashset for the value
        }

        list.add(val); // Add the value to the end of the list
        map.get(val).add(list.size() - 1); // Add the index of the value to its hashset in the map

        return keyExists ? false : true; // If the value already exists, return false; otherwise, return true
    }

    public boolean remove(int val) {
        if (!map.containsKey(val)) return false; // If the value doesn't exist in the map, return false

        int index = map.get(val).iterator().next(); // Get the first index of the value in the map's hashset
        map.get(val).remove(index); // Remove the index from the map's hashset

        int lastElement = list.get(list.size() - 1); // Get the last element in the list
        list.set(index, lastElement); // Overwrite the element at the index with the last element
        map.get(lastElement).add(index); // Add the index of the overwritten element to its hashset in the map
        map.get(lastElement).remove(list.size() - 1); // Remove the index of the last element from its hashset in the map

        list.remove(list.size() - 1); // Remove the last element from the list

        if (map.get(val).size() == 0) map.remove(val); // If the hashset for the value is empty, remove the value from the map

        return true; // Return true
    }

    public int getRandom() {
        return list.get(random.nextInt(list.size())); // Get a random element from the list
    }
}
