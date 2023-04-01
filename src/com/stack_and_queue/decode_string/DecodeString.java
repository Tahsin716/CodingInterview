package com.stack_and_queue.decode_string;

import java.util.Stack;

public class DecodeString {
    public String decodeString(String s) {
        // Create two stacks to store numbers and strings
        Stack<Integer> numStack = new Stack<>();
        Stack<StringBuilder> stringBuilderStack = new Stack<>();

        // Initialize the current string and number
        StringBuilder currentStringBuilder = new StringBuilder();
        int currentNum = 0;

        // Loop through each character of the input string
        for (char c : s.toCharArray()) {
            // If the current character is a digit, update the current number
            if (Character.isDigit(c)) {
                currentNum = currentNum * 10 + (c - '0');
            }
            // If the current character is an opening bracket, store the current number and string
            // in their respective stacks, and reset the current number and string to empty
            else if (c == '[') {
                numStack.push(currentNum);
                stringBuilderStack.push(currentStringBuilder);
                currentNum = 0;
                currentStringBuilder = new StringBuilder();
            }
            // If the current character is a closing bracket, repeat the string stored in the
            // current string variable by the number stored in the number stack
            else if (c == ']') {
                // temporary string builder to hold current string
                StringBuilder temp = currentStringBuilder;
                // get the previous string builder from the stack
                currentStringBuilder = stringBuilderStack.pop();
                // get the repeat times from the stack
                int repeatTimes = numStack.pop();

                // repeat the current string which is now temp, by the repeat times
                // in the currentStringBuilder which is now previous string builder
                for (int i = 0; i < repeatTimes; i++) {
                    currentStringBuilder.append(temp);
                }
            }
            // If the current character is a letter, append it to the current string
            else {
                currentStringBuilder.append(c);
            }
        }

        // Return the final decoded string
        return currentStringBuilder.toString();
    }
}
