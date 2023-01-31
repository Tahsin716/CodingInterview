package com.trees.binary_tree.binary_tree_postorder_traversal;

import com.common.datastructure.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePostorderTraversal_Iterative_ReversePreorder {
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> list = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;

        // We will perform a reverse preorder traversal, root - right - left
        // and use a linked list to add the node value at the front.
        // Despite yielding correct result this strategy would be wrong if topological dependency
        // is important, as we would have to complete the child nodes before the head node is processed.
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                list.addFirst(current.val);
                current = current.right;
            }

            current = stack.pop();
            current = current.left;
        }

        return list;
    }
}
