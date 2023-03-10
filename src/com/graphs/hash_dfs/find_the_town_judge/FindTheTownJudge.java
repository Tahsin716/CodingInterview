package com.graphs.hash_dfs.find_the_town_judge;

public class FindTheTownJudge {
    public int findJudge(int n, int[][] trust) {
        // Create an array to keep track of the trust count for each person
        int[] person = new int[n + 1];

        // Update the trust count for each person based on the trust relationships
        for (int[] personTrust: trust) {
            // Decrement the trust count for the person who trusts someone else
            person[personTrust[0]]--;
            // Increment the trust count for the person who is trusted by someone else
            person[personTrust[1]]++;
        }

        // Find the person who is trusted by all other people and does not trust anyone else
        for (int i = 1; i <= n; i++)
            if (person[i] == n - 1) return i;

        // If there is no such person, return -1
        return -1;
    }
}

