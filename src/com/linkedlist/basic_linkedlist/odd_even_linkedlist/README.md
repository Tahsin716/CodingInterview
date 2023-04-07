### Approach

The basic idea of the algorithm is to keep track of two pointers, one for the odd nodes and one for the even nodes, and traverse the list while connecting the odd and even nodes.

We use odd to keep track of the last odd node and connect it to the next odd node, and similarly for even. 

Finally, we connect the end of the odd list to the head of the even list to get the final reordered list.