package com.maths.add_binary;

public class AddBinary {
    public String addBinary(String a, String b) {
        // Create a StringBuilder to store the result
        StringBuilder stringBuilder = new StringBuilder();
        // Initialize indices for traversing strings a and b from the end
        int i = a.length() - 1, j = b.length() - 1;
        // Initialize carry to 0
        int carry = 0;

        // Traverse both strings from the end and add their corresponding digits and the carry
        while (i >= 0 || j >= 0 || carry != 0) {
            // If i, is still within the bounds of string 'a', get its current digit
            // Otherwise, set firstNum to 0
            int firstNum = (i >= 0) ? a.charAt(i) - '0' : 0;
            // If j is still within the bounds of string b, get its current digit
            // Otherwise, set secondNum to 0
            int secondNum = (j >= 0) ? b.charAt(j) - '0': 0;

            // Add the current digits and the carry
            int sum = firstNum + secondNum + carry;
            // Append the least significant bit of the sum to the StringBuilder
            stringBuilder.append(sum % 2);
            // Update the carry to the most significant bit of the sum
            carry = sum / 2;

            // Decrement the indices i and j
            if (i >= 0) i--;
            if (j >= 0) j--;
        }

        // Reverse the order of the bits in the StringBuilder and convert it to a String
        return stringBuilder.reverse().toString();
    }
}

