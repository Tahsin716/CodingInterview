package com.arrays.hash_table.insert_delete_getrandom;

import java.util.ArrayList;
import java.util.HashMap;

public class InsertDeleteGetRandom {
    // Define a private HashMap to store the values and their indices
    private HashMap<Integer, Integer> map;
    // Define a private ArrayList to store the values
    private ArrayList<Integer> list;
    // Define a private Random object to generate random numbers
    private java.util.Random random;

    // Define a constructor to initialize the HashMap, ArrayList, and Random object
    public InsertDeleteGetRandom() {
        map = new HashMap<>();
        list = new ArrayList<>();
        random = new java.util.Random();
    }

    // Define a method to insert a value into the set
    public boolean insert(int val) {
        // If the value is already in the set, return false
        if (map.containsKey(val)) return false;

        // Add the value to the end of the ArrayList and put the value and its index in the HashMap
        list.add(val);
        map.put(val, list.size() - 1);

        // Return true to indicate that the insertion was successful
        return true;
    }

    // Define a method to remove a value from the set
    public boolean remove(int val) {
        // If the value is not in the set, return false
        if (!map.containsKey(val)) return false;

        // Get the index of the value in the ArrayList
        int index = map.get(val);

        // If the value is not the last element in the ArrayList, swap it with the last element
        if (index != list.size() - 1) {
            swap(list, index, list.size() - 1);
            // Update the index of the value that was swapped
            map.put(list.get(index), index);
        }

        // Remove the value from the end of the ArrayList and from the HashMap
        list.remove(list.size() - 1);
        map.remove(val);

        // Return true to indicate that the removal was successful
        return true;
    }

    // Define a private method to swap two elements in an ArrayList
    private void swap(ArrayList<Integer> list, int i, int j) {
        int temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }

    // Define a method to get a random value from the set
    public int getRandom() {
        // Generate a random index and return the value at that index in the ArrayList
        return list.get(random.nextInt(list.size()));
    }
}

