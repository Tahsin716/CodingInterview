package com.trees.binary_tree.same_tree;

import com.common.datastructure.TreeNode;

public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // Both nodes are null, so both nodes are same
        if (p == null && q == null) return true;

        // Only one node among theme is null, so not same
        if (p == null || q == null) return false;

        // The value for both nodes are not same
        if (p.val != q.val) return false;

        // Check if the left and right subtree of both trees are same
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
