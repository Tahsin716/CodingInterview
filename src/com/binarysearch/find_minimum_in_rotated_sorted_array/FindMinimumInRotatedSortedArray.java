package com.binarysearch.find_minimum_in_rotated_sorted_array;

public class FindMinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        int n = nums.length;
        int start = 0, end = nums.length - 1, mid, prev, next;

        if (n == 1) return nums[0];

        while (start <= end) {
            mid = start + (end - start) / 2;

            // mid is in the first index, so 0 - 1 will lead to negative index
            // so (0 - 1 + n) % n will form a circular array, and prev will be
            // assigned to last index
            prev = (mid - 1 + n) % n;

            // mid is int the last index, so +1 will lead to index out of bounds
            // (mid + 1) % n, will cycle the next to first index of the array
            next = (mid + 1) % n;

            // nums[mid] is less than both nums[next] and nums[prev], so nums[mid] is the
            // min element
            if (nums[mid] < nums[prev] && nums[mid] < nums[next]) return nums[mid];

            // since nums[end] is less than nums[mid]
            // nums[mid] ... nums[end] is not sorted, and the min lies in the
            // unsorted portion of the array
            if (nums[end] < nums[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return -1;
    }
}
