package com.arrays.hash_table.k_diff_pairs_in_an_array;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int findPairs(int[] nums, int k) {
        // Create a HashMap to store the frequency of each element in the array
        HashMap<Integer, Integer> map = new HashMap<>();
        // Initialize a counter to keep track of the number of k-diff pairs found
        int pairs = 0;

        // Iterate over the array and update the frequency of each element in the HashMap
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        // Iterate over the entries in the HashMap
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            // If k is zero, we count the number of elements with frequency greater than 1, eg: 2 - 2 = 0
            // If k is greater than zero, we check if there is an element in the HashMap with value equal to key + k
            if ((k == 0 && entry.getValue() > 1) || (k > 0 && map.containsKey(entry.getKey() + k))) {
                // If the condition is satisfied, increment the counter
                pairs++;
            }
        }

        // Return the number of k-diff pairs found
        return pairs;
    }
}

