package com.backtracking.palindrome_partitioning;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        // create an empty list to store the result
        List<List<String>> result = new ArrayList<>();

        // call the backtrack function to generate all palindromic substrings
        backtrack(0, s, new ArrayList<>(), result);

        // return the result
        return result;
    }

    private void backtrack(int index, String s, List<String> tempList, List<List<String>> result) {
        // if we have reached the end of the string, add the current partition to the result
        if (index == s.length()) {
            result.add(new ArrayList<>(tempList));
            return;
        }

        // generate all possible substrings starting from the current index
        for (int i = index; i < s.length(); i++) {
            // if the substring is not palindromic, skip it
            if (!isPalindrome(index, i, s)) continue;

            // add the palindromic substring to the current partition
            tempList.add(s.substring(index, i + 1));

            // recursively generate partitions starting from the next index
            backtrack(i + 1, s, tempList, result);

            // remove the current substring to backtrack and try a different substring
            tempList.remove(tempList.size() - 1);
        }
    }

    private boolean isPalindrome(int start, int end, String s) {
        // check if the substring from start to end is a palindrome
        while (start < end) {
            if (s.charAt(start++) != s.charAt(end--)) return false;
        }

        return true;
    }
}

