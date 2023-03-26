package com.strings.add_strings;

public class AddStrings {
    public String addStrings(String num1, String num2) {
        // initialize variables
        int carry = 0;
        int ptr1 = num1.length() - 1, ptr2 = num2.length() - 1;
        StringBuilder builder = new StringBuilder();

        // iterate until both strings are empty and there is no carry left
        while (ptr1 >= 0 || ptr2 >= 0 || carry != 0) {
            // get the numeric value of the characters at the current pointers
            int firstNum = ptr1 >= 0 ? Character.getNumericValue(num1.charAt(ptr1)) : 0;
            int secondNum = ptr2 >= 0 ? Character.getNumericValue(num2.charAt(ptr2)) : 0;

            // add the two numbers along with the carry
            int sum = firstNum + secondNum + carry;
            carry = sum / 10; // get the carry for the next iteration
            sum = sum % 10; // get the current digit to append

            // append the current digit to the string builder
            builder.append(sum);

            // move the pointers leftwards in the strings
            if (ptr1 >= 0) ptr1--;
            if (ptr2 >= 0) ptr2--;
        }

        // reverse the string builder and return the result as a string
        builder.reverse();
        return builder.toString();
    }
}

