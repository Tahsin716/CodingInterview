package com.trees.binary_tree.diameter_of_binary_tree;

import com.common.datastructure.TreeNode;

public class DiameterOfBinaryTree {
    // similar to max depth of binary tree, use a global variable maxDiameter
    // to store the answer after finding the left and right height of the tree
    int maxDiameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return maxDiameter;
    }

    private int dfs(TreeNode root) {
        if (root == null) return 0;

        // Diameter of a given node equal to the left and right height of subtrees passing
        // through the given node, currentDiameter = leftHeight + rightHeight
        int left = dfs(root.left);
        int right = dfs(root.right);
        int currentDiameter = left + right;

        // Store the maxDiameter for the current node
        maxDiameter = Math.max(maxDiameter, currentDiameter);

        // return the max height between left and right, +1 for the height of current node's edge to it's parent;
        // to calculate the diameter of the parent node
        return Math.max(left, right) + 1;
    }
}
