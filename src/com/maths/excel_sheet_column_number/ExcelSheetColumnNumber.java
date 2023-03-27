package com.maths.excel_sheet_column_number;

public class ExcelSheetColumnNumber {
    public int titleToNumber(String columnTitle) {
        // Initialize the result to 0
        int result = 0;
        // Get the last index of the column title string
        int lastIndex = columnTitle.length() - 1;

        // Loop through each character of the column title string
        for (int i = 0; i < columnTitle.length(); i++) {
            // Get the current character of the column title string, from right to left
            char c = columnTitle.charAt(lastIndex - i);
            // Convert the character to its corresponding value by subtracting the ASCII value of 'A'
            // and adding 1 for 1-based index
            int value = (c - 'A') + 1;
            // Multiply the value with 26 raised to the power of the current index, and add it to the result
            // formula: result += value * 26^i
            result += value * Math.pow(26, i);
        }

        // Return the result
        return result;
    }
}
