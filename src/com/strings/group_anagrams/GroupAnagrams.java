package com.strings.group_anagrams;

import java.util.*;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        // Create a hashmap to store the anagrams and their corresponding list of words
        Map<String, List<String>> map = new HashMap<>();

        // Loop through each word in the array of strings
        for (String s : strs) {
            // Convert the word to a character array and sort it
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars); // Convert the sorted character array back to a string

            // If the sorted string is already in the hashmap, add the word to the corresponding list
            if (map.containsKey(key)) {
                map.get(key).add(s);
            }
            // Otherwise, create a new list with the word and add it to the hashmap with the sorted string as the key
            else {
                List<String> list = new ArrayList<>();
                list.add(s);
                map.put(key, list);
            }
        }

        // Return the values of the hashmap (which are lists of anagrams) as a list of lists
        return new ArrayList<>(map.values());
    }
}

