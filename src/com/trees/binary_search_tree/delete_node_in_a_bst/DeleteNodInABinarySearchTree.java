package com.trees.binary_search_tree.delete_node_in_a_bst;

import com.common.datastructure.TreeNode;

public class DeleteNodInABinarySearchTree {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;

        // Search the node with the given key
        if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else {
            // If the left subtree of the node to be removed is null, then we remove the current node with its
            // right subtree by returning root.right
            if (root.left == null) return root.right;

            // If the right subtree of the node to be removed is null, then we remove the current node with its
            // left subtree by returning root.left
            if (root.right == null) return root.left;

            // Both left and right subtree exists for the current node that we need to remove.
            // so we will attach the right subtree at the end max node in left subtree, and return
            // root.left to remove the current node
            TreeNode maxLeftNode = findMax(root.left);
            maxLeftNode.right = root.right;
            return root.left;
        }

        return root;
    }

    private TreeNode findMax(TreeNode node) {
        TreeNode current = node;

        while (current.right != null) {
            current = current.right;
        }

        return current;
    }
}
