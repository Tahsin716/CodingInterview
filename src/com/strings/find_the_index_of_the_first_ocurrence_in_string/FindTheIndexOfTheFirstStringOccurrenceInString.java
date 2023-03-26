package com.strings.find_the_index_of_the_first_ocurrence_in_string;

public class FindTheIndexOfTheFirstStringOccurrenceInString {
    public int strStr(String haystack, String needle) {
        // If the needle is empty, then it's always found at index 0 of haystack
        if (needle.isEmpty()) {
            return 0;
        }

        // Get the length of the haystack and needle
        int haystackLength = haystack.length(), needleLength = needle.length();

        // Loop over the haystack string to search for the needle
        for (int i = 0; i <= haystackLength - needleLength; i++) {
            // If the current character of haystack matches the first character of needle
            if (haystack.charAt(i) == needle.charAt(0)) {
                int index = 1;

                // Check if the remaining characters of haystack match the remaining characters of needle
                while (index < needleLength && haystack.charAt(i + index) == needle.charAt(index)) {
                    index++;
                }

                // If all characters of needle were found in haystack
                if (index == needleLength) {
                    // Return the index of the first occurrence of needle
                    return i;
                }
            }
        }

        // Return -1 if the needle was not found in haystack
        return -1;
    }
}

