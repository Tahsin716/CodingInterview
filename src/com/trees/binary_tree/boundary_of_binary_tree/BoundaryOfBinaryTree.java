package com.trees.binary_tree.boundary_of_binary_tree;

import com.common.datastructure.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BoundaryOfBinaryTree {
    // Boundary of a binary tree (anti-clockwise)
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();

        if (root == null) return result;

        // Insert the root node if it is not a leaf node
        if (!isLeafNode(root)) {
            result.add(root.val);
        }

        // Insert the left nodes of the tree, excluding leaf nodes
        addLeftBoundary(root.left, result);

        // Insert the leaf nodes of the tree
        addLeaves(root, result);

        // Insert the right nodes of the tree, excluding leaf nodes
        // in a stack which will later be popped in the result list
        addRightBoundary(root.right, stack);

        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }

        return result;
    }

    private void addLeftBoundary(TreeNode root, List<Integer> result) {
        if (root == null || isLeafNode(root)) return;

        result.add(root.val);

        if (root.left != null) {
            addLeftBoundary(root.left, result);
        } else {
            addLeftBoundary(root.right, result);
        }
    }

    private void addLeaves(TreeNode node, List<Integer> result) {
        if (node == null) return;

        if (node.left == null && node.right == null) {
            result.add(node.val);
            return;
        }

        if (node.left != null) {
            addLeaves(node.left, result);
        }

        if (node.right != null) {
            addLeaves(node.right, result);
        }
    }

    private void addRightBoundary(TreeNode node, Stack<Integer> stack) {
        if (node == null || isLeafNode(node)) return;

        stack.push(node.val);

        if (node.right != null) {
            addRightBoundary(node.right, stack);
        } else {
            addRightBoundary(node.left, stack);
        }
    }

    private boolean isLeafNode(TreeNode node) {
        return node.left == null && node.right == null;
    }
}
