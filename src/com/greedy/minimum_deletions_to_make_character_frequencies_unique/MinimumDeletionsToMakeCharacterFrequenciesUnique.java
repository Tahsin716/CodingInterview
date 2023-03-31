package com.greedy.minimum_deletions_to_make_character_frequencies_unique;

import java.util.HashSet;
import java.util.Set;

public class MinimumDeletionsToMakeCharacterFrequenciesUnique {
    public int minDeletions(String s) {
        // initialize an array to store frequency of each character
        int[] freq = new int[26];
        // initialize a variable to store the number of deletions required
        int deletions = 0;

        // increment the frequency of each character in the string
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        // initialize a set to store used frequencies
        Set<Integer> usedFreq = new HashSet<>();

        for (int i = 0; i < 26; i++) {
            // get the frequency of the current character
            int currFreq = freq[i];

            // decrement the frequency until a unique frequency is found
            // increment the number of deletions required
            while (currFreq > 0 && usedFreq.contains(currFreq)) {
                currFreq--;
                deletions++;
            }

            // add the unique frequency to the set
            if (currFreq > 0) {
                usedFreq.add(currFreq);
            }
        }

        // return the number of deletions required to make frequencies unique
        return deletions;
    }
}

