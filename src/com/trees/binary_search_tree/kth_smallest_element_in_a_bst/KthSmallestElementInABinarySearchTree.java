package com.trees.binary_search_tree.kth_smallest_element_in_a_bst;

import com.common.datastructure.TreeNode;

public class KthSmallestElementInABinarySearchTree {
    int index;
    int num;
    public int kthSmallest(TreeNode root, int k) {
        index = 0;
        dfs(root, k);
        return num;
    }

    // Inorder traversal of the tree, to find the kth index element
    private void dfs(TreeNode node, int k) {
        if (node == null) return;

        dfs(node.left, k);

        if (++index == k) {
            num = node.val;
            return;
        }

        dfs(node.right, k);
    }
}
