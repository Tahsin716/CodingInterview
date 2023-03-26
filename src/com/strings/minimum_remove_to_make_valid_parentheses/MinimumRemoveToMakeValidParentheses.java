package com.strings.minimum_remove_to_make_valid_parentheses;

import java.util.Stack;

public class MinimumRemoveToMakeValidParentheses {
    public String minRemoveToMakeValid(String s) {
        // Create a stack to keep track of opening parentheses positions
        Stack<Integer> stack = new Stack<>();

        // Convert the input string to a character array
        char[] arr = s.toCharArray();

        // Traverse the character array
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '(') { // if an opening parenthesis is found, push its index to the stack
                stack.push(i);
            } else if (arr[i] == ')') { // if a closing parenthesis is found
                if (!stack.isEmpty()) { // check if there is a matching opening parenthesis in the stack
                    stack.pop(); // if so, remove it from the stack
                } else { // if not, mark the closing parenthesis for removal
                    arr[i] = '#';
                }
            }
        }

        // Any remaining opening parentheses in the stack should be marked for removal
        while (!stack.isEmpty()) {
            int index = stack.pop();
            arr[index] = '#';
        }

        // Build the resulting string by excluding the marked parentheses
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '#') continue;
            builder.append(arr[i]);
        }

        // Return the resulting string
        return builder.toString();
    }
}

