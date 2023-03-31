package com.greedy.minimum_time_to_make_rope_colorful;

public class MinimumTimeToMakRopeColorful {
    public int minCost(String colors, int[] neededTime) {
        if (colors.length() == 1) return 0;

        // Initialize the variable to store the minimum cost required
        int time = 0;

        // Iterate through the string 'colors'
        for (int i = 1; i < colors.length(); i++) {
            char currentBalloon = colors.charAt(i);
            char previousBalloon = colors.charAt(i - 1);

            // If the current and previous balloons are not of the same color, continue iterating
            if (currentBalloon != previousBalloon) continue;

            // If the current and previous balloons are of the same color, calculate the minimum time required
            time += Math.min(neededTime[i], neededTime[i - 1]);

            // Update the neededTime array with the maximum time required
            neededTime[i] = Math.max(neededTime[i], neededTime[i - 1]);
        }

        // Return the minimum cost required
        return time;
    }
}

