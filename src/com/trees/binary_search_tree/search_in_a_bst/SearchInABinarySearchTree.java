package com.trees.binary_search_tree.search_in_a_bst;

import com.common.datastructure.TreeNode;

public class SearchInABinarySearchTree {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null || root.val == val) return root;

        TreeNode node = null;

        if (val < root.val) {
            node = searchBST(root.left, val);
        } else if (val > root.val) {
            node = searchBST(root.right, val);
        }

        return node;
    }
}
