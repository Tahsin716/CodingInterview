package com.maths.excel_sheet_column_title;

public class ExcelSheetColumnTitle {
    public String convertToTitle(int columnNumber) {
        // StringBuilder to store the result
        StringBuilder builder = new StringBuilder();

        while (columnNumber > 0) {
            // Decrease the column number by 1 to handle 1-based indexing
            columnNumber--;
            // Get the current character
            char c = (char) ('A' + (columnNumber % 26));

            // Append the current character to the StringBuilder
            builder.append(c);
            // Divide the column number by 26 for the next iteration
            columnNumber /= 26;
        }

        // Reverse the StringBuilder and convert it to a String
        return builder.reverse().toString();
    }
}

