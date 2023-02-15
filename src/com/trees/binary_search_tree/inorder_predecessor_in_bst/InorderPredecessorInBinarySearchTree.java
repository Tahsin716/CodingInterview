package com.trees.binary_search_tree.inorder_predecessor_in_bst;

import com.common.datastructure.TreeNode;

public class InorderPredecessorInBinarySearchTree {
    TreeNode predecessor = null;

    // Inorder predecessor in binary search tree is the greatest value for which, predecessor < node
    // The idea is similar to finding floor in a BST
    public TreeNode inorderPredecessor(TreeNode root, TreeNode p) {
        findPredecessor(root, p);
        return predecessor;
    }

    private void findPredecessor(TreeNode node, TreeNode p) {
        if (node == null) return;

        if (node.val < p.val) {
            predecessor = node;
            findPredecessor(node.right, p);
        } else if (node.val >= p.val) {
            findPredecessor(node.left, p);
        }
    }
}
