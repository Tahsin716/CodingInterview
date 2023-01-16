package com.arrays.two_pointers.sort_colors;

public class SortColors_2Pass {
    public void sortColors(int[] nums) {

        // Use three variables, to store count of 0s, 1s and 2s
        // Iterate the array again to fill the 0s, 1s, and 2s
        // in their respective order, with the help of the three counter variables
        int zeroCount = 0, oneCount = 0, twoCount = 0;

        for (int num : nums) {
            if (num == 0) {
                zeroCount++;
            }
            else if (num == 1) {
                oneCount++;
            }
            else {
                twoCount++;
            }
        }

        for(int i = 0; i < nums.length; i++) {
            if (zeroCount-- > 0) {
                nums[i] = 0;
            }
            else if (oneCount-- > 0) {
                nums[i] = 1;
            }
            else {
                nums[i] = 2;
            }
        }
    }
}
