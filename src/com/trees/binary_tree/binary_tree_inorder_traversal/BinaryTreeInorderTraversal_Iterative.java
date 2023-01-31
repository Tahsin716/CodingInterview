package com.trees.binary_tree.binary_tree_inorder_traversal;

import com.common.datastructure.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal_Iterative {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;

        while (current != null || !stack.isEmpty()) {
            // While the current node is not null, push the current node into stack
            // and keep traversing left
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            // There are no more elements on the left
            // so add node value into list and traverse right
            current = stack.pop();
            list.add(current.val);
            current = current.right;
        }

        return list;
    }
}
