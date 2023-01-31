package com.trees.binary_tree.symmetric_tree;

import com.common.datastructure.TreeNode;

public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }

    // The isMirror function is similar to that of isSameTree from the problem SameTree
    // only difference is since we are trying to check symmetry of the tree
    // we will check if the left subtree of tree A is same as right subtree of tree B
    // similarly right subtree of tree A is same as left subtree of tree B
    private boolean isMirror(TreeNode rootA, TreeNode rootB) {
        if (rootA == null && rootB == null) return true;

        if (rootA == null || rootB == null) return false;

        if (rootA.val != rootB.val) return false;

        return isMirror(rootA.left, rootB.right) && isMirror(rootA.right, rootB.left);
    }
}
