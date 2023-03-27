### Approach

The problem requires us to check if a given integer n is a power of two.

The solution checks if n is less than or equal to 0. If n is less than or equal to 0, then it is not a power of two and the function returns false.

If n is greater than 0, then we repeatedly divide n by 2 until n is no longer divisible by 2. If n becomes 1 at the end of this process, it means that n was originally a power of 2. Otherwise, it is not a power of 2.