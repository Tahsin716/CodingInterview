package com.trees.binary_tree.subtree_of_another_tree;

import com.common.datastructure.TreeNode;

public class SubtreeOfAnotherTree {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        // If S is empty, then T cannot be a subtree of S
        if (s == null)
            return false;

        // If S and T have the same structure and nodes, then T is a subtree of S
        if (isSame(s, t))
            return true;

        // If T is not a subtree of S, recursively check if it is a subtree of the left or right subtree of S
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    public boolean isSame(TreeNode s, TreeNode t) {
        // If both S and T are empty, then they are the same
        if (s == null && t == null)
            return true;

        // If either S or T is empty, then they are not the same
        if (s == null || t == null)
            return false;

        // If the values of the current nodes of S and T are not the same, then they are not the same tree
        if (s.val != t.val)
            return false;

        // Recursively check if the left and right subtrees of S and T are the same
        return isSame(s.left, t.left) && isSame(s.right, t.right);
    }
}

