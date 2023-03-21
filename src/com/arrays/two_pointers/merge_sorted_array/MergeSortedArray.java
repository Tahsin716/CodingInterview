package com.arrays.two_pointers.merge_sorted_array;

public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // Two pointers to point at the end elements of both arrays,
        // and a third pointer to point at the end of first array to insert from the end index
        int index1 = m - 1, index2 = n - 1;
        int currentIndex = m + n - 1;

        // Use two pointers and merge the sorted array from end of the array
        while (index1 >= 0 && index2 >= 0) {
            if (nums1[index1] >= nums2[index2]) {
                nums1[currentIndex] = nums1[index1];
                index1--;
            } else if (nums1[index1] < nums2[index2]) {
                nums1[currentIndex] = nums2[index2];
                index2--;
            }
            currentIndex--;
        }

        // Loop through the second array again to merge the remaining elements if any
        while (index2 >= 0) {
            nums1[currentIndex] = nums2[index2];
            index2--;
            currentIndex--;
        }
    }
}
