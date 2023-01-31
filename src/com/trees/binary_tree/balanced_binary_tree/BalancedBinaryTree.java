package com.trees.binary_tree.balanced_binary_tree;

import com.common.datastructure.TreeNode;

public class BalancedBinaryTree {
    // Similar to max depth of binary tree, but we need to return a boolean
    // to identify whether it is a balanced binary tree or not
    public boolean isBalanced(TreeNode root) {
        // if the height is not -1, then the tree is height balanced
        return getHeight(root) != -1;
    }

    private int getHeight(TreeNode node) {
        if (node == null) return 0;

        // Get the left tree height
        int leftHeight = getHeight(node.left);
        // if the height is -1 then the left tree is not balanced, so return -1
        if (leftHeight == -1) return -1;

        // Get the right tree height
        int rightHeight = getHeight(node.right);
        // if the height is -1, then the right tree is not balanced, so return -1
        if (rightHeight == -1) return -1;

        // Check the difference in height between, left and right subtree
        // if the difference is greater than 1, then it is not balanced so return -1
        if (Math.abs(rightHeight - leftHeight) > 1) return -1;

        // return the max height between left and right subtree, and +1 for current node height
        return Math.max(rightHeight, leftHeight) + 1;
    }
}
