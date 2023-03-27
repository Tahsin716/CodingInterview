package com.maths.maximum_product_of_three_numbers;

public class MaximumProductOfThreeNumbers {
    public int maximumProduct(int[] nums) {
        // Initialize the minimum values and maximum values for the three numbers
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;

        // Iterate through the array to find the minimum and maximum values
        for (int num : nums) {
            if (num <= min1) {  // Found a new minimum value
                min2 = min1;
                min1 = num;
            } else if (num <= min2) {  // Found a second minimum value
                min2 = num;
            }

            if (num >= max1) {  // Found a new maximum value
                max3 = max2;
                max2 = max1;
                max1 = num;
            } else if (num >= max2) {  // Found a second maximum value
                max3 = max2;
                max2 = num;
            } else if (num >= max3) {  // Found a third maximum value
                max3 = num;
            }
        }

        // Return the maximum product of three numbers
        return Math.max(min1 * min2 * max1, max1 * max2 * max3);
    }
}

