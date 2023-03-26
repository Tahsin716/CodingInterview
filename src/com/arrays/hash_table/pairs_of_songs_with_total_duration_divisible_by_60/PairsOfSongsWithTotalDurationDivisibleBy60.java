package com.arrays.hash_table.pairs_of_songs_with_total_duration_divisible_by_60;

import java.util.HashMap;

public class PairsOfSongsWithTotalDurationDivisibleBy60 {
    public int numPairsDivisibleBy60(int[] time) {
        // Initialize a hash map named map to store the count of songs with a particular remainder when divided by 60.
        HashMap<Integer, Integer> map = new HashMap<>();
        // Initialize an integer variable named pairCount to store the number of pairs whose total duration is divisible by 60.
        int pairCount = 0;

        // Iterate over the input array time using a for-each loop.
        for (int num : time) {
            // Calculate the remainder of the current song's duration when divided by 60.
            int remainder = num % 60;
            // Calculate the complementary remainder needed to form a pair whose total duration is divisible by 60.
            int complementaryRemainder = (60 - remainder) % 60;
            // Add the count of songs with the complementary remainder to the pairCount.
            pairCount += map.getOrDefault(complementaryRemainder, 0);
            // Update the count of songs with the current remainder in the map.
            map.put(remainder, map.getOrDefault(remainder, 0) + 1);
        }

        // Return the pairCount.
        return pairCount;
    }
}

