package com.trees.binary_tree.maximum_depth_of_binary_tree;

import com.common.datastructure.TreeNode;

public class MaximumDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;

        // Height of left tree
        int left = maxDepth(root.left);
        // Height of right tree
        int right = maxDepth(root.right);

        // max between left and right tree, and +1 for current node's height
        return Math.max(left, right) + 1;
    }
}
