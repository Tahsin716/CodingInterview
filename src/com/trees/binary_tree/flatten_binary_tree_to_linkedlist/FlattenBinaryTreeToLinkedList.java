package com.trees.binary_tree.flatten_binary_tree_to_linkedlist;

import com.common.datastructure.TreeNode;

public class FlattenBinaryTreeToLinkedList {
    public void flatten(TreeNode root) {
        if (root == null) return; // base case: empty tree

        // recursively flatten left and right subtrees
        flatten(root.left);
        flatten(root.right);

        // save left and right subtrees before modifying the tree structure
        TreeNode left = root.left;
        TreeNode right = root.right;

        // clear left subtree and make it the new right subtree
        root.left = null;
        root.right = left;

        // traverse the new right subtree to find the last node
        TreeNode node = root;
        while (node != null && node.right != null) {
            node = node.right;
        }

        // attach the original right subtree to the last node in the new right subtree
        node.right = right;
    }
}

