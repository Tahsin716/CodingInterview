package com.binarysearch.square_root_x;

public class SquareRootX {
    public int mySqrt(int x) {
        // initialize the start and end of the search range
        int start = 0, end = x, ans = 0;

        // while there are still numbers to search
        while (start <= end) {
            // calculate the midpoint of the search range
            long mid = start + (end - start) / 2;
            // calculate the product of the midpoint with itself
            long product = mid * mid;

            // if the product is less than or equal to x, update the start and ans
            if (product <= x) {
                start = (int) mid + 1;
                ans = (int) mid;
            }
            // if the product is greater than x, update the end
            else {
                end = (int) mid - 1;
            }
        }

        // return the integer square root
        return ans;
    }
}
