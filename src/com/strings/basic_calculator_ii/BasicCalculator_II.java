package com.strings.basic_calculator_ii;

import java.util.Stack;

public class BasicCalculator_II {
    public int calculate(String s) {
        // If the input string is null or empty, return 0.
        if(s == null || s.length() == 0) return 0;

        // Create a stack to hold the numbers.
        Stack<Integer> stack = new Stack<Integer>();

        // Initialize current number to 0 and current operator to '+'
        int currentNum = 0;
        char currentOperator = '+';

        // Traverse the string character by character
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // If the character is a digit, update the current number.
            if (Character.isDigit(c)){
                currentNum = currentNum * 10 + (c -'0');
            }

            // If the character is an operator or the last character of the string, perform the operation.
            if (!Character.isDigit(c) && !Character.isWhitespace(c) || i == s.length() - 1){
                switch (currentOperator) {
                    case '+':
                        stack.push(currentNum);
                        break;
                    case '-':
                        stack.push(-currentNum);
                        break;
                    case '*':
                        stack.push(stack.pop() * currentNum);
                        break;
                    case '/':
                        stack.push(stack.pop() / currentNum);
                        break;
                }

                // Update the current operator to the new operator and reset the current number.
                currentOperator = c;
                currentNum = 0;
            }
        }

        // Calculate the final result by adding all the numbers in the stack.
        int result = 0;
        while (!stack.isEmpty()) {
            result += stack.pop();
        }

        // Return the final result.
        return result;
    }
}

