package com.trees.binary_search_tree.validate_bst;

import com.common.datastructure.TreeNode;

public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        return isValidBSTHelper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBSTHelper(TreeNode node, long min, long max) {
        if (node == null) return true;

        if (node.val >= max || node.val <= min) return false;

        // All node values in left subtree is less than current node.val, so max = node.val
        // All node values in right subtree is greater than current node.val, so min = node.val
        return isValidBSTHelper(node.left, min, node.val) && isValidBSTHelper(node.right, node.val, max);
    }
}
