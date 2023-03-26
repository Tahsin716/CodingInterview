package com.arrays.prefix_sum.product_of_array_except_self;

public class ProductOfArrayExceptSelf_OneArray {
    public int[] productExceptSelf(int[] nums) {
        // Get the length of the input array
        int n = nums.length;
        // Define a new array with the same length as the input array to store the result
        int[] ans = new int[n];
        // Define a variable named right to keep track of the right product
        int right = 1;

        // Set the first element of the result array to 1
        ans[0] = 1;

        // Calculate the left product of each element and store it in the result array
        for (int i = 1; i < n; i++) {
            ans[i] = nums[i - 1] * ans[i - 1];
        }

        // Calculate the right product of each element and multiply it with the left product of the same element
        for (int j = n - 2; j >= 0; j--) {
            right = right * nums[j + 1];
            ans[j] = ans[j] * right;
        }

        // Return the result array
        return ans;
    }
}
