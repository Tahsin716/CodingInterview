package com.binarysearch.ceil_of_an_element;

public class CeilOfAnElement {
    public int ceil(int[] nums, int element) {
        int start = 0, end = nums.length, mid, result = -1;

        while (start <= end) {
            mid = start + (end - start) / 2;

            if (element == nums[mid]) return mid;

            if (nums[mid] > element) {
                // Ceil = smallest element, greater than target
                result = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return result;
    }
}
