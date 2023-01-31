package com.trees.binary_tree.binary_tree_maximum_path_sum;

import com.common.datastructure.TreeNode;

public class BinaryTreeMaximumPathSum {
    // Similar to diameter of binary tree, just ignore negative paths
    // as they will never yield to max path sum
    int maxValue;

    public int maxPathSum(TreeNode root) {
        maxValue = Integer.MIN_VALUE;
        dfs(root);

        return maxValue;
    }

    private int dfs(TreeNode node) {
        if (node == null) return 0;

        // Find path sum for left and right subtree
        // ignore negative paths as they will never yield to max path sum
        // so instead just take 0, if path sum is negative
        int left = Math.max(0, dfs(node.left));
        int right = Math.max(0, dfs(node.right));

        // current path sum = current node value + left subtree sum + right subtree sum
        int currentPathSum = node.val + left + right;

        // Store the max path sum
        maxValue = Math.max(maxValue, currentPathSum);

        // return max path sum between left and right subtree + current node value
        // to calculate max path sum for parent node
        return Math.max(left, right) + node.val;
    }
}
