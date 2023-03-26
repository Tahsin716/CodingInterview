package com.strings.roman_to_integer;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
    public int romanToInt(String s) {
        // Create a map to store the Roman numeral values
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int result = 0;
        int prev = 0;

        // Traverse the Roman numeral string from right to left
        for (int i = s.length() - 1; i >= 0; i--) {
            // Get the value of the current Roman numeral
            int curr = map.get(s.charAt(i));

            // If the value of the current Roman numeral is less than the previous one, subtract it
            if (curr < prev) {
                result -= curr;
            }
            // Otherwise, add it to the result
            else {
                result += curr;
            }

            // Update the previous Roman numeral value for the next iteration
            prev = curr;
        }

        return result;
    }
}
