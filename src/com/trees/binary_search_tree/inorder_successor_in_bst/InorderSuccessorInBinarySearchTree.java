package com.trees.binary_search_tree.inorder_successor_in_bst;

import com.common.datastructure.TreeNode;

public class InorderSuccessorInBinarySearchTree {
    TreeNode successor = null;

    // Inorder successor in binary search tree is the lowest value for which, successor > node
    // The idea is similar to finding ceil in a BST
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        findSuccessor(root, p);
        return successor;
    }

    private void findSuccessor(TreeNode node, TreeNode p) {
        if (node == null) return;

        if (node.val > p.val) {
            successor = node;
            findSuccessor(node.left, p);
        } else if (node.val <= p.val) {
            findSuccessor(node.right, p);
        }

    }
}
