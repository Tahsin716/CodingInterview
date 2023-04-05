package com.binarysearch.find_peak_element;

public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        // initialize left and right pointers and mid to -1
        int left = 0, right = nums.length - 1, mid = -1;

        // binary search until left <= right
        while (left <= right) {
            // calculate mid index
            mid = left + (right - left) / 2;

            // get the elements to the left and right of the mid-index
            int leftElement = mid == 0 ? Integer.MIN_VALUE :  nums[mid - 1];
            int rightElement = mid == nums.length - 1 ? Integer.MIN_VALUE : nums[mid + 1];

            // check if the mid-index is a peak element
            if (leftElement < nums[mid] && rightElement < nums[mid]) {
                return mid;
            }
            // if the element to the left of mid is greater, search the left half
            else if (leftElement > nums[mid]) {
                right = mid - 1;
            }
            // otherwise, search the right half
            else {
                left = mid + 1;
            }
        }

        // return mid if no peak element was found
        return mid;
    }
}

