package com.arrays.hash_table.two_sum;

import java.util.HashMap;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] result = new int[2];

        for (int i = 0; i < nums.length; i++) {
            // Find the difference between current number and target
            int difference = target - nums[i];

            // If the difference exists in map, that means we can for a sum
            if (map.containsKey(difference)) {
                result[0] = i;
                result[1] = map.get(difference);
                break;
            } else { // We were not able to find the difference to make the sum, so insert the current number and it's index
                map.put(nums[i], i);
            }
        }

        return result;
    }
}
