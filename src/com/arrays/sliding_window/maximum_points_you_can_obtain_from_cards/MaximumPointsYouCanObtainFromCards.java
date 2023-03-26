package com.arrays.sliding_window.maximum_points_you_can_obtain_from_cards;

public class MaximumPointsYouCanObtainFromCards {
    public int maxScore(int[] cardPoints, int k) {
        int sum = 0, max = 0, n = cardPoints.length;

        // Compute the sum of the first k elements from the left end of the array.
        for (int i = 0; i < k; i++) sum += cardPoints[i];

        // Initialize max with the sum computed above.
        max = sum;

        // Consider the sum of the k cards starting from the right end of the array.
        for (int i = 0; i < k; i++) {
            // Remove the leftmost card from the current sum and add the card from the right end.
            sum = sum - cardPoints[k - i - 1] + cardPoints[n - i - 1];
            // Update max with the maximum of the current sum and the previous maximum.
            max = Math.max(max, sum);
        }

        return max;
    }
}

