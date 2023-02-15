package com.trees.binary_search_tree.insert_into_a_bst;

import com.common.datastructure.TreeNode;

public class InsertIntoABinarySearchTree {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        // There are many ways of inserting into a BST, for simplicity we will insert the node
        // at the end of the BST
        if (root == null) return new TreeNode(val);

        if (val > root.val) {
            root.right = insertIntoBST(root.right, val);
        } else {
            root.left = insertIntoBST(root.left, val);
        }

        return root;
    }
}
