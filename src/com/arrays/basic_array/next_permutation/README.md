### Approach

If we plot the numbers on a graph, we will find *peak* and *valleys*. We need to **swap** the nearest *valley* from the rightmost *peak*. And then **sort** all the elements after the *valley index* which we swapped with the *peak*.

* Iterate the array from the end while **nums[i] >= nums[i + 1]** to find the valley index to swap.

* Check if **i >= 0** , if yes then we found the valley index, now we need to find the *smallest peak* value for which *nums[i] < nums[j]*. Iterate from the end of the array while **nums[i] >= nums[j]**, then swap num[i] and nums[j].

* After swapping the *peak* and *valley* we need to **sort** the elements after valley index. That is because lets say we have an array: [1, 3, 5, 4, 2] -> 13542 after swapping the *peak* and *valley* we would get: [1, 4, 5, 3, 2] -> 14532 but that is not the next greater permutation. The next greater permutation would be: [1, 4, 2, 3, 5] -> 14235.

If no valley index was found, that means the array is in descending order, so the whole array should be sorted in ascending order.

#### Complexity

Space Complexity: **O(1)** <br>
Time Complexity: **O(n)**