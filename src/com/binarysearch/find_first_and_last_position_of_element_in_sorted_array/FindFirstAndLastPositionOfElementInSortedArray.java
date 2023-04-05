package com.binarysearch.find_first_and_last_position_of_element_in_sorted_array;

public class FindFirstAndLastPositionOfElementInSortedArray {
    public int[] searchRange(int[] nums, int target) {
        // Initialize the answer array with -1 as both start and end indices
        int[] ans = new int[]{-1, -1};

        // If the input array is empty, return the answer array
        if (nums.length == 0) return ans;

        // Find the starting index of the target value in the array
        int start = findStart(nums, target);

        // If the starting index is -1 or the value at the starting index is not equal to the target value,
        // then the target value is not present in the array. Return the answer array.
        if (start == -1 || nums[start] != target) return ans;

        // Store the starting index in the answer array
        ans[0] = start;

        // Find the last index of the target value in the array
        int end = findLast(nums, target);

        // Store the last index in the answer array
        ans[1] = end;

        // Return the answer array
        return ans;
    }

    // Helper function to find the starting index of the target value in the array using binary search
    private int findStart(int[] nums, int target) {
        int left = 0, right = nums.length - 1, mid;
        int ans = -1;

        // Perform binary search to find the starting index
        while (left <= right) {
            mid = left + (right - left) / 2;

            // If the middle element is equal to the target value, store the index in the ans variable
            if (nums[mid] == target)  {
                ans = mid;
            }

            // If the middle element is greater than or equal to the target value, move the right pointer to mid - 1
            if (nums[mid] >= target) {
                right = mid - 1;
            } else { // If the middle element is less than the target value, move the left pointer to mid + 1
                left = mid + 1;
            }
        }

        // Return the starting index of the target value
        return ans;
    }

    // Helper function to find the last index of the target value in the array using binary search
    private int findLast(int[] nums, int target) {
        int left = 0, right = nums.length - 1, mid;
        int ans = -1;

        // Perform binary search to find the last index
        while (left <= right) {
            mid = left + (right - left) / 2;

            // If the middle element is equal to the target value, store the index in the ans variable
            if (nums[mid] == target) {
                ans = mid;
            }

            // If the middle element is less than or equal to the target value, move the left pointer to mid + 1
            if (nums[mid]  <= target) {
                left = mid + 1;
            } else { // If the middle element is greater than the target value, move the right pointer to mid - 1
                right = mid - 1;
            }
        }

        // Return the last index of the target value
        return ans;
    }
}

