package com.arrays.two_pointers.three_sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        // Sort the array, else we won't be able to use two pointers
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        // We need to pick three numbers, so first iteration < nums.length - 2
        // This makes sure there are two more numbers left
        for (int i = 0; i < nums.length - 2; i++) {

            // Ignore duplicate, as current num is same as previous num
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            // Slight optimization, as the numbers are sorted
            // and the first number is greater than 0, so the rest numbers will also be
            // greater, thus there is no way of making a sum of 0 with three numbers
            if (nums[i] > 0) break;

            int start = i + 1, end = nums.length - 1;

            // We picked nums[i], so current target = 0 - nums[i]
            int target = 0 - nums[i];

            // nums[i] + num[start] + nums[end] = 0
            // nums[start] + nums[end] = 0 - nums[i]
            // num[start] + nums[end] = target
            //
            // So we need to make a sum, that is equal to target
            while (start < end) {
                int sum = nums[start] + nums[end];

                if (sum > target) {
                    end--;
                }
                else if (sum < target) {
                    start++;
                }
                else {
                    // We found a triplet so add them to result
                    result.add(new ArrayList<>(List.of(nums[i], nums[start], nums[end])));

                    // We already made a triplet with nums[start], so we ignore same number and move start forward
                    while (start < end && nums[start] == nums[start + 1]) start++;

                    // We already made a triplet with nums[end], so we ignore same number and move end backward
                    while (start < end && nums[end] == nums[end - 1]) end--;

                    start++;
                    end--;
                }
            }
        }

        return result;
    }
}
