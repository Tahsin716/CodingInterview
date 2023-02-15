package com.trees.binary_search_tree.lowest_common_ancestor_of_a_bst;

import com.common.datastructure.TreeNode;

public class LowestCommonAncestorOfABinarySearchTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        // If current node value is greater than both node p and q, then lca lies in the left subtree
        // else if current node value is lower than both node p and q, then lca lies in the right subtree
        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        }

        // else we found the lca so return the node
        return root;
    }
}
