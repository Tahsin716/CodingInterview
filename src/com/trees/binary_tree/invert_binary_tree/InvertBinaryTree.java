package com.trees.binary_tree.invert_binary_tree;

import com.common.datastructure.TreeNode;

public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;

        // Traverse down the left and right subtree and assign them to left and right respectively
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);

        // swap the left subtree and right subtree with root.left and root.right pointers
        root.left = right;
        root.right = left;

        return root;
    }
}
