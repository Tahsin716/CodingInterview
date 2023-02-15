package com.trees.binary_search_tree.bst_iterator;

import com.common.datastructure.TreeNode;

import java.util.Stack;

public class BinarySearchTreeIterator {
    Stack<TreeNode> stack;

    public BinarySearchTreeIterator(TreeNode root) {
        stack = new Stack<>();
        insert(root);
    }

    public int next() {
        TreeNode node = stack.pop();
        // insert the right child node, and then all the left child nodes from node.right
        insert(node.right);
        return node.val;
    }

    public boolean hasNext() {
        return stack.isEmpty() ? false : true;
    }

    private void insert(TreeNode node) {
        if (node == null) return;

        TreeNode current = node;

        // Insert the node and traverse the left subtree and insert
        // all the left child nodes
        while (current != null) {
            stack.push(current);
            current = current.left;
        }

    }
}
