package com.trees.binary_tree.binary_tree_preorder_traversal;

import com.common.datastructure.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePreorderTraversal_Iterative {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;

        while (current != null || !stack.isEmpty()) {

            // While current node is not null, insert node value into result list
            // and keep traversing left
            while (current != null) {
                stack.push(current);
                // Preorder -> root - left right
                // so insert the node value into result list
                list.add(current.val);
                current = current.left;
            }

            // no node in left, so pop the node from stack
            // and traverse right
            current = stack.pop();
            current = current.right;
        }

        return list;
    }
}
