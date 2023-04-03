package com.trees.binary_tree.path_sum_iii;

import com.common.datastructure.TreeNode;

public class PathSum_BruteForce {
    // This variable will hold the count of paths that sum up to the given sum
    int count = 0;

    // This method takes a binary tree and a target sum and returns the count of paths that sum up to the given sum
    public int pathSum(TreeNode root, int sum) {
        // If the root is null, there can't be any path that sums up to the given sum, so return 0
        if (root == null)
            return 0;

        // Count the number of paths that sum up to the given sum starting from the root
        findPath(root, sum);
        // Recursively count the number of paths that sum up to the given sum starting from the left and right subtrees
        pathSum(root.left, sum);
        pathSum(root.right, sum);

        // Return the count of paths that sum up to the given sum
        return count;
    }

    // This method takes a node in the tree and a target sum and updates the count of paths that sum up to the given sum
    public void findPath(TreeNode node, long sum) {
        // If the node is null, there can't be any path that sums up to the given sum, so return
        if (node == null)
            return;

        // If the value of the node equals the target sum, increment the count
        if (node.val == sum)
            count++;

        // Recursively search for paths that sum up to the target sum in the left and right subtrees
        findPath(node.left, sum - node.val);
        findPath(node.right, sum - node.val);

        // Return
        return;
    }
}

