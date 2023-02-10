package com.trees.binary_tree.lowest_common_ancestor_of_a_binary_tree;

import com.common.datastructure.TreeNode;

public class LowestCommonAncestorOfABinaryTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // If root is null or equal to either one of the nodes, then return root
        if (root == null || root == p || root == q)
            return root;

        // Traverse the left subtree for the given nodes and then right subtree
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // If left node is null then return right node
        if (left == null)
            return right;

        // If right node is null then return left node
        if (right == null)
            return left;

        // If neither one of the left nor right nodes are null,
        // the root node is LCA, so return root
        return root;
    }
}
