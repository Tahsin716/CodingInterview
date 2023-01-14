package com.binarysearch.floor_of_an_element;

public class FloorOfAnElement {
    public int floor(int[] nums, int element) {
        int start = 0, end = nums.length - 1, mid, result = -1;

        while (start <= end) {
            mid = start + (end - start) / 2;

            if (element == nums[mid]) return mid;

            if (nums[mid] < element) {
                // Floor = greatest element, smaller than target
                result = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return result;
    }
}
