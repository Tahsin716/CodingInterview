package com.arrays.two_pointers.trapping_rain_water;

public class TrappingRainWater_DP {
    public int trap(int[] height) {
        int n = height.length;
        int[] maxLeft = new int[n];
        int[] maxRight = new int[n];
        int result = 0, max = 0;

        // Block of water that can be trapped in position 'i' is determined by the formula
        // min(maxLeft[i], maxRight[i]) - height[i].
        // If the trapped water is less than 0, we will round it to 0 as negative block of water is illogical.
        //
        // Iterate the height array from both from the start and end to find
        // the maxLeft and maxRight element respectively.

        // height:   [0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1]
        // maxLeft:  [0, 0, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3]
        // maxRight: [3, 3, 3, 3, 3, 3, 3, 2, 2, 2, 1, 0]
        // min(L,R): [0, 0, 1, 1, 2, 2, 2, 2, 2, 2, 1, 0]

        for (int i = 0; i < n; i++) {
            maxLeft[i] = max;
            max = Math.max(max, height[i]);
        }

        max = 0;

        for (int i = n - 1; i >= 0; i--) {
            maxRight[i] = max;
            max = Math.max(max, height[i]);
        }



        for (int i = 0; i < n; i++) {
            int waterVolume = Math.min(maxLeft[i], maxRight[i]) - height[i];
            waterVolume = waterVolume < 0 ? 0 : waterVolume;
            result += waterVolume;
        }


        return result;
    }
}
