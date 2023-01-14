package com.binarysearch.single_element_in_sorted_array;

public class SingleElementInSortedArray {
    public int singleNonDuplicate(int[] nums) {
        int start = 0, end = nums.length - 1;

        // Check boundary cases, if there is only one element
        // If unique element is at start or at the end
        if (end == 0) return nums[0];
        if (nums[start] != nums[start + 1]) return nums[start];
        if (nums[end] != nums[end - 1]) return nums[end];

        while (start <= end) {
            int mid = start + (end - start) / 2;
            boolean isMidAtEvenIndex = mid % 2 == 0;
            boolean isMidAtOddIndex = mid % 2 == 1;

            if (nums[mid] != nums[mid - 1] && nums[mid] != nums[mid + 1]) return nums[mid];

            // The pairs always start at an odd index and end at an even index
            // if a unique element is present it will disrupt this order, so after the unique element
            // the pair will start at odd index and end at even index
            //
            // If mid is at even index and the pair starts at mid, i.e. even index that means unique element
            // does not lie between start...mid+1 as order was not disrupted
            //
            // Similarly if mid is at odd index and pair starts at mid - 1, i.e. even index that also means
            // unique element does not lie between start...mid, so shift start = mid + 1
            if ((isMidAtEvenIndex && nums[mid] == nums[mid + 1]) ||
                    (isMidAtOddIndex && nums[mid] == nums[mid - 1])) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return -1;
    }
}
