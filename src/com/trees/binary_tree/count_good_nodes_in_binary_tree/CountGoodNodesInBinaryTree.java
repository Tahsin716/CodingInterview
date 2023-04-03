package com.trees.binary_tree.count_good_nodes_in_binary_tree;

import com.common.datastructure.TreeNode;

public class CountGoodNodesInBinaryTree {
    public int goodNodes(TreeNode root) {
        // Call the dfs function starting from the root node and passing the minimum integer value as the initial max value
        return dfs(root, Integer.MIN_VALUE);
    }

    private int dfs(TreeNode node, int max) {
        // If the current node is null, return 0
        if (node == null) return 0;

        // Initialize a variable to hold the count of good nodes
        int result = 0;

        // If the value of the current node is greater than or equal to the max value seen so far, it is a good node
        if (max <= node.val) result++;

        // Update the max value seen so far to be the maximum of the current max and the value of the current node
        max = Math.max(max, node.val);

        // Recursively call the dfs function on the left and right child nodes, passing the updated max value
        result += dfs(node.left, max);
        result += dfs(node.right, max);

        // Return the count of good nodes found in this subtree
        return result;

    }
}

