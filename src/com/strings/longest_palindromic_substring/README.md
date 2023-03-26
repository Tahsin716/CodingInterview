### Approach

The solution makes use of the fact that a palindrome has two centers. 
It uses a helper method expandAroundCenter to find the length of the longest palindrome with the given center(s). 

The longestPalindrome method takes in a string s, initializes start and end indices to 0, and iterates through the string s. 
For each character in s, it calls expandAroundCenter twice, once with the current character as the center, and once with the current character and its neighbor as center. 

It takes the maximum length palindrome from both the cases, and if this is greater than the length of the longest palindrome found so far, it updates the starting and ending indices of the longest palindrome found so far. 
Finally, it returns the longest palindrome substring.