package com.trees.binary_tree.path_in_a_tree;

import java.util.ArrayList;

public class PathInATree {
    public static ArrayList<Integer> pathInATree(TreeNode root, int x) {
        ArrayList<Integer> result = new ArrayList<>();

        dfs(root, x, result);

        return result;
    }

    private static boolean dfs(TreeNode node, int target, ArrayList<Integer> result) {
        if (node == null) return false;

        // Insert the current node value in the list
        result.add(node.data);

        // If the current node value equals target, then we found the node so return true
        if (node.data == target) return true;

        // Check if the target node exists in left subtree, if yes, return true
        if (dfs(node.left, target, result)) return true;

        // Check if the target node exists in right subtree, if yes, return true
        if (dfs(node.right, target, result)) return true;

        // We didn't find the target node in neither left nor right subtree, so no path exists from current node
        // hence remove the current node from the list
        result.remove(result.size() - 1);

        return false;
    }

    private static class TreeNode
    {
        int data;
        TreeNode left, right;

        public TreeNode(int item)
        {
            data = item;
            left = right = null;
        }
    }
}
