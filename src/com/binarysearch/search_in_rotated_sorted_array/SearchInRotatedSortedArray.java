package com.binarysearch.search_in_rotated_sorted_array;

public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        int n = nums.length;

        int start = 0, end = n - 1, index = -1;
        int minIndex = findMinIndex(nums);
        int prevIndex = minIndex > 0 ? minIndex - 1 : minIndex;

        // minIndex == start == 0, so the array is fully sorted
        if (minIndex == start) {
            index = binarySearch(nums, target, start, end);
        }
        // target lies in between: nums[start]...target...nums[prevIndex], nums[minIndex]...nums[end]
        else if (target >= nums[start] && target <= nums[prevIndex]) {
            index = binarySearch(nums, target, start, prevIndex);
        }
        // target lies in between: num[start]...nums[prevIndex], nums[minIndex]...target...nums[end]
        else if (target >= nums[minIndex] && target <= nums[end]) {
            index = binarySearch(nums, target, minIndex, end);
        }

        return index;
    }

    private int binarySearch(int[] nums, int target, int start, int end) {
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (target == nums[mid]) return mid;

            if (target > nums[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return -1;
    }

    private int findMinIndex(int[] nums) {
        int n = nums.length;
        int start = 0, end = n - 1, mid, prev, next;

        if (n == 1) return 0;

        while (start <= end) {
            mid = start + (end - start) / 2;
            prev = (mid - 1 + n) % n;
            next = (mid + 1) % n;

            if (nums[mid] < nums[prev] && nums[mid] < nums[next]) return mid;

            if (nums[end] < nums[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return -1;
    }
}
