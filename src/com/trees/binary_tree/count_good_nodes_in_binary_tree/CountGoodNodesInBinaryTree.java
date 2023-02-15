package com.trees.binary_tree.count_good_nodes_in_binary_tree;

import com.common.datastructure.TreeNode;

public class CountGoodNodesInBinaryTree {
    public int goodNodes(TreeNode root) {
        // Pass down the max node value in the path, as you traverse down the tree
        return dfs(root, Integer.MIN_VALUE);
    }

    private int dfs(TreeNode node, int max) {
        if (node == null) return 0;

        int result = 0;

        if (max <= node.val) result++;

        max = Math.max(max, node.val);

        result += dfs(node.left, max);
        result += dfs(node.right, max);

        return result;

    }
}
