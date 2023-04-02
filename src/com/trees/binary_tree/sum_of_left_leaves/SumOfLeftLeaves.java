package com.trees.binary_tree.sum_of_left_leaves;

import com.common.datastructure.TreeNode;

public class SumOfLeftLeaves {
    public int sumOfLeftLeaves(TreeNode root) {
        // Base case: if the root is null, return 0.
        if (root == null) return 0;

        int sum = 0;

        // Check if the left child of the root is a leaf node.
        // If it is, add its value to the sum.
        if (root.left != null && root.left.left == null && root.left.right == null)
            sum += root.left.val;

        // Recursively call the function on the left and right subtrees
        // and add the results to the sum.
        sum += sumOfLeftLeaves(root.left);
        sum += sumOfLeftLeaves(root.right);

        // Return the final sum.
        return sum;
    }
}

