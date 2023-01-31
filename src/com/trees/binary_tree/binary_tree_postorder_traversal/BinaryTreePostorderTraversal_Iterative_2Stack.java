package com.trees.binary_tree.binary_tree_postorder_traversal;

import com.common.datastructure.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePostorderTraversal_Iterative_2Stack {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();

        if (root == null) return result;

        // Insert root element into first stack
        stack1.push(root);

        // While the first stack is not empty
        while (!stack1.isEmpty()) {
            TreeNode current = stack1.pop();
            // Push the root element into second stack
            stack2.push(current);

            // Let's say the tree is [1, 2, 3]
            // 1 gets inserted into stack2 = [1]
            // 2 and 3 into stack1 = [3, 2]
            // we traverse 3, and it gets inserted into stack2 = [3, 1]
            // we then traverse 2, and it gets inserted into stack2 = [2, 3, 1]
            if (current.left != null) stack1.push(current.left);
            if (current.right != null) stack1.push(current.right);
        }

        while (!stack2.isEmpty()) {
            result.add(stack2.pop().val);
        }

        return result;
    }
}
