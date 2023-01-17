package com.arrays.cyclic_sort.kth_missing_positive_number;

import java.util.HashSet;
import java.util.Set;

public class KthMissingPositiveNumber {
    public int findKthPositive(int[] arr, int k) {
        int n = arr.length;

        // Insert the numbers in a set for O(1) look up if the number is missing
        Set<Integer> set = new HashSet<>();
        for (int num : arr) set.add(num);

        // Iterate from 1...arr[n-1], 1 to last element in array to find missing number
        for (int i = 1; i <= arr[n - 1]; i++) {
            // If the number is not in set, then its missing so decrement 'k'
            // In order to find the kth missing number
            if (!set.contains(i)) {
                k--;
            }

            // We found the kth missing number so return number
            if (k == 0) return i;
        }

        // Kth missing number was not in between 1...arr[n-1]
        // its arr[n-1] + k
        return arr[n - 1] + k;
    }
}
