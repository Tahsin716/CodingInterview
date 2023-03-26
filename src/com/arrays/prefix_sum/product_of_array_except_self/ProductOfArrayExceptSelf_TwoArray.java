package com.arrays.prefix_sum.product_of_array_except_self;

public class ProductOfArrayExceptSelf_TwoArray {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];

        left[0] = 1;

        // Calculate left product of each element and store it in array
        for (int i = 1; i < n; i++) {
            left[i] = nums[i - 1] * left[i - 1];
        }

        right[n - 1] = 1;

        // Calculate right product of each element and store it in array
        for (int j = n - 2; j >= 0; j--) {
            right[j] = nums[j + 1] * right[j + 1];
        }

        int[] ans = new int[n];

        // Calculate the left and right product of each element except self, and store it in array
        for (int i = 0; i < n; i++) {
            ans[i] = left[i] * right[i];
        }

        return ans;
    }
}
