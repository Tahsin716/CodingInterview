package com.trees.binary_search_tree.recover_bst;

import com.common.datastructure.TreeNode;

public class RecoverBinarySearchTree {
    // Keep three nodes to find the swapped nodes
    TreeNode first, second, prev;

    public void recoverTree(TreeNode root) {
        dfs(root);
        swap();
    }

    // Perform inorder traversal to find the node values in sorted order
    private void dfs(TreeNode node) {
        if (node == null) return;

        dfs(node.left);

        // first node is null and prev node is either null or greater than current node value
        // then assign first node as prev node
        if (first == null && (prev == null || prev.val >= node.val)) {
            first = prev;
        }

        // if first node is not null and prev node is greater than current node value
        // assign second node as current node
        if (first != null && prev.val >= node.val) {
            second = node;
        }

        // shift prev node to current node
        prev = node;


        dfs(node.right);
    }

    private void swap() {
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
}
