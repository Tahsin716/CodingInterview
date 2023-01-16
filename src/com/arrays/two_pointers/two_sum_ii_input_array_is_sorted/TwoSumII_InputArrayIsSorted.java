package com.arrays.two_pointers.two_sum_ii_input_array_is_sorted;

public class TwoSumII_InputArrayIsSorted {
    public int[] twoSum(int[] numbers, int target) {
        int start = 0, end = numbers.length - 1;

        // The indices of two numbers which make up the target
        int[] ans = new int[2];

        // Use Binary Search to find the two numbers that make up target
        // start < end, because we need to choose two numbers, same number cannot be chosen twice
        // It is mentioned that the numbers will have at least 2 numbers
        while (start < end) {
            // Sum made up from the two numbers pointed by start and end pointer
            int sum = numbers[start] + numbers[end];

            if (sum < target ) {
                start++;
            }
            else if (sum > target) {
                end--;
            }
            else {
                // We found the two numbers, assign the index '+1' as the question mentioned for us to do so
                ans[0] = start + 1;
                ans[1] = end + 1;
                break;
            }
        }

        return ans;
    }
}
