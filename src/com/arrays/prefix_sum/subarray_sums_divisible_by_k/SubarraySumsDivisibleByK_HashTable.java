package com.arrays.prefix_sum.subarray_sums_divisible_by_k;

import java.util.HashMap;

public class SubarraySumsDivisibleByK_HashTable {
    public int subarraysDivByK(int[] nums, int k) {
        int count = 0; // number of subarrays that are divisible by k
        int sum = 0; // sum of elements in a subarray
        HashMap<Integer, Integer> map = new HashMap<>(); // to store sum % k and its frequency

        // sum from the beginning of the array to the current index is divisible by k
        // sum(0...i) % k = 0
        map.put(sum, 1); // initialize the map with 0 mod k

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i]; // add the current number to the sum
            sum %= k; // take mod k to get the remainder

            if (sum < 0) sum += k; // handle negative remainder

            count += map.getOrDefault(sum, 0); // add the frequency of sum % k to the count
            map.put(sum, map.getOrDefault(sum, 0) + 1); // add the current sum % k to the map
        }

        return count; // return the total count of subarrays that are divisible by k
    }
}

