package com.trees.binary_search_tree.minimum_absolute_difference_in_bst;

import com.common.datastructure.TreeNode;

public class MinimumAbsoluteDifferenceInBST {
    int minDiff = Integer.MAX_VALUE; // variable to store the minimum absolute difference

    Integer prev = null; // variable to store the previous node's value

    public int getMinimumDifference(TreeNode root) {
        inorder(root); // perform inorder traversal of the BST

        return minDiff; // return the minimum absolute difference
    }

    private void inorder(TreeNode root) {
        if (root == null) {
            return;
        }

        inorder(root.left); // traverse the left subtree

        if (prev != null) {
            minDiff = Math.min(minDiff, Math.abs(root.val - prev)); // calculate the minimum absolute difference
        }

        prev = root.val; // update the previous node's value

        inorder(root.right); // traverse the right subtree
    }
}

