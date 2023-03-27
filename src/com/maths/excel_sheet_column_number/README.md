### Approach

The formula used to convert the column title to its corresponding column number is:

```javascript
result += value * 26^i;
```

where value is the value of the current character, and i is the current index (starting from 0). 
The formula is based on the fact that there are 26 letters in the English alphabet and each column is represented by a combination of one or more letters. 
The first column is represented by the letter 'A', the second column by 'B', and so on. The 27th column is represented by 'AA', the 28th column by 'AB', and so on.