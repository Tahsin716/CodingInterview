package com.arrays.prefix_sum.subarray_sum_equals_k;

import java.util.HashMap;

public class SubArraySumEqualsK_HashTable {
    public int subarraySum(int[] nums, int k) {
        // Create a new hashmap called map to store the count of prefix sums that we have encountered so far.
        HashMap<Integer, Integer> map = new HashMap<>();
        // Initialize the sum variable to 0 and the count variable to 0.
        int sum = 0, count = 0;

        // Add a new key-value pair to the map where key is 0 and value is 1.
        // sum from the beginning to the current index is equal k, sum(0....i) = k
        map.put(sum, 1);

        // Iterate through the nums array using a for loop.
        for (int i = 0; i < nums.length; i++) {
            // Add the current element to the sum.
            sum += nums[i];

            // Check if the map contains a key equal to sum - k. If it does, add the value associated with that key to the count variable.
            // Similar to TwoSum problem
            // let sum = x, sum - k = y
            // x + y = k
            // So number of different subarray we can form with 'x' + 'y', is the total number of subarray 'y' we have found, stored in the map
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }

            // We store the total number of occurrences of subarray 'x'
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        // Return the count variable.
        return count;
    }
}
