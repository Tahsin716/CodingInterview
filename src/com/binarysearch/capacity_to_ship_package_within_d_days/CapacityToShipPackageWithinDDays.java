package com.binarysearch.capacity_to_ship_package_within_d_days;

public class CapacityToShipPackageWithinDDays {
    public int shipWithinDays(int[] weights, int days) {
        int sum = 0, max = 0, start, end, mid, ans = 0;

        // Find the min and max search space of the capacity of the ship
        // The max value of package weight will be the min capacity of the ship
        // Whereas the sum of all weights will be the max capacity of the ship
        for (int weight : weights) {
            sum += weight;
            max = Math.max(max, weight);
        }

        start = max;
        end = sum;

        // Search space is max(weights)...sum(weights)
        while (start <= end) {
            mid = start + (end - start) / 2;

            if (isValid(weights, days, mid)) {

                // We found a valid weight capacity of the ship, but we need to find the least weight capacity
                // As in floor value, so we will look for the value in left side of the search space
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return ans;
    }

    private boolean isValid(int[] weights, int days, int capacity) {
        int total = 0, daysCount = 1;

        for (int weight : weights) {
            total += weight;

            // If total is greater than capacity, that means we cannot ship the current package today
            // It has to be shipped tomorrow, so we set total = weight (current package weight)
            // and increment daysCount as we need to ship the package next day
            if (total > capacity) {
                total = weight;
                daysCount++;
            }

            // We need more days to ship than the given days, so we cannot ship all packages with
            // given capacity of the ship
            if (daysCount > days) return false;
        }

        return true;
    }
}
