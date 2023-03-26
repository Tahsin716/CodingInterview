package com.strings.integer_to_roman;

public class IntegerToRoman {
    public String intToRoman(int num) {
        StringBuilder result = new StringBuilder();
        int[] values = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        // loop through each value in the values array
        for (int i = 0; i < values.length; i++) {
            // while the input num is greater than or equal to the current value
            while (num >= values[i]) {
                // append the corresponding symbol to the result
                result.append(symbols[i]);
                // subtract the current value from num
                num -= values[i];
            }
        }
        // return the final result
        return result.toString();
    }
}

