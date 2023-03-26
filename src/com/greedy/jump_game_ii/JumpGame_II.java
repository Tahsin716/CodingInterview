package com.greedy.jump_game_ii;

public class JumpGame_II {
    public int jump(int[] nums) {
        int jumps = 0, maxLevelJumps = 0, currentLevelJumps = 0;

        // Loop through all indices except the last one
        for (int i = 0; i < nums.length - 1; i++) {
            // Update the maximum jump distance from the current index
            maxLevelJumps = Math.max(maxLevelJumps, i + nums[i]);

            // If we have reached the last index in the current level of jumps
            if (i == currentLevelJumps) {
                // Increment the jump count
                jumps++;
                // Move to the next level of jumps
                currentLevelJumps = maxLevelJumps;
            }
        }

        // Return the minimum number of jumps needed to reach last index
        return jumps;
    }
}
