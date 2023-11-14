package com.binarysearch.koko_eating_bananas;

public class KokoEatingBananas {
    public int minEatingSpeed(int[] piles, int h) {
        int start = 1, end = 1, mid, ans = 0;

        // Find the max value of the search space
        for (int pile : piles) {
            end = Math.max(end, pile);
        }

        // Search space is from 1...max(piles)
        while (start <= end) {
            // mid = bananas-per-hour eating speed of k
            mid = start + (end - start) / 2;

            if (isValid(piles, h, mid)) {

                // Koko was able to eat all the bananas in the pile within the given hour
                // for the speed = mid, but we need to find the smallest value of 'k'
                // so we will look for the value in left side of the search space
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return ans;
    }

    // Find if for the given speed, koko can eat all the bananas
    // in the pile within given hour
    private boolean isValid(int[] piles, int h, int speed) {
        int hourSpent = 0;

        for (int pile : piles) {
            hourSpent += Math.ceil((double)pile / speed);
        }

        return hourSpent <= h;
    }
}
