package com.greedy.jump_game;

public class JumpGame {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int maxReach = 0;

        for (int i = 0; i < n; i++) {
            // If we cannot reach the current position, return false
            if (i > maxReach) {
                return false;
            }

            // Update the furthest position that we can reach from the current position
            maxReach = Math.max(i + nums[i], maxReach);

            // If we can reach the last index, return true
            if (maxReach >= n - 1) {
                return true;
            }
        }

        // We cannot reach the last index, so return false
        return false;
    }
}

