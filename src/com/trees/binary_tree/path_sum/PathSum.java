package com.trees.binary_tree.path_sum;

import com.common.datastructure.TreeNode;

public class PathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        // Base case: the root is null, so return false
        if (root == null) return false;

        // Base case: the root is a leaf node, and its value equals the target sum, so return true
        if (root.left == null && root.right == null) return root.val == targetSum;

        // Recursively check if the left or right subtree has a path sum equal to targetSum - root.val
        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }
}

