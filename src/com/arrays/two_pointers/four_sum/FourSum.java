package com.arrays.two_pointers.four_sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        // Sort the array, else we won't be able to use two pointers
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        // We need to pick four elements, so first iteration < nums.length - 3
        // This makes sure there are three numbers left
        for (int i = 0; i < nums.length - 3; i++) {

            // Current num same as previous num, so ignore to avoid duplicate
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            // We picked nums[i], so newTarget = target - nums[i]
            long newTarget = target - nums[i];

            // We still have two more numbers to pick so second iteration < nums.length - 2
            // This makes sure there are two more numbers left
            for (int j = i + 1; j < nums.length - 2; j++) {

                // Current num same as previous num, so ignore to avoid duplicate
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;

                int start = j + 1, end = nums.length - 1;

                // We picked nums[j] so current target = previousTarget - nums[j]
                long currentTarget = newTarget - nums[j];

                // nums[i] + nums[j] + nums[start] + nums[end] = target
                // nums[start] + nums[end] = target - nums[i] - nums[j]
                // nums[start] + nums[end] = currentTarget
                //
                // So we need to make a sum, that is equal to currentTarget
                while (start < end) {
                    long sum =  nums[start] + nums[end];

                    if (sum > currentTarget) {
                        end--;
                    }
                    else if (sum < currentTarget) {
                        start++;
                    }
                    else {
                        // We found a quadruplet so insert it into result
                        result.add(new ArrayList<>(List.of(nums[i], nums[j], nums[start], nums[end])));

                        // Ignore duplicates by avoiding repeated nums[start]
                        while (start < end && nums[start] == nums[start + 1]) start++;

                        // Ignore duplicates by avoid repeated nums[end]
                        while (start < end && nums[end] == nums[end - 1]) end--;

                        start++;
                        end--;
                    }
                }
            }
        }

        return result;
    }
}
