package com.trees.binary_tree.binary_tree_paths;

import com.common.datastructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>(); // create a list to store the paths

        if (root == null) { // if the root is null, return an empty list
            return result;
        }

        dfs(root, "", result); // call the depth-first search function with the root node and an empty string

        return result; // return the list of paths
    }

    // depth-first search function to traverse the binary tree
    private void dfs(TreeNode node, String path, List<String> result) {
        if (node.left == null && node.right == null) { // if the current node is a leaf node
            result.add(path + node.val); // add the path to the result list
            return; // return from the function
        }

        if (node.left != null) { // if the left child of the current node exists
            dfs(node.left, path + node.val + "->", result); // call the dfs function recursively with the left child node and the current path appended with the current node value and a "->" symbol
        }

        if (node.right != null) { // if the right child of the current node exists
            dfs(node.right, path + node.val + "->", result); // call the dfs function recursively with the right child node and the current path appended with the current node value and a "->" symbol
        }
    }
}

