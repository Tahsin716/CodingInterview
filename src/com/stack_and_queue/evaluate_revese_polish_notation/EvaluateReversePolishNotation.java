package com.stack_and_queue.evaluate_revese_polish_notation;

import java.util.Stack;

public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {
            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                calculate(stack, token);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();
    }

    private void calculate(Stack<Integer> stack, String token) {
        int secondNum = stack.pop();
        int firstNum = stack.pop();

        switch (token) {
            case "+" -> stack.push(firstNum + secondNum);
            case "-" -> stack.push(firstNum - secondNum);
            case "*" -> stack.push(firstNum * secondNum);
            case "/" -> stack.push(firstNum / secondNum);
        }
    }
}
