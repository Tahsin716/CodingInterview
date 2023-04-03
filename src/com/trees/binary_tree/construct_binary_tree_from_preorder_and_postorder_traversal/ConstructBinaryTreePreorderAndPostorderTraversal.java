package com.trees.binary_tree.construct_binary_tree_from_preorder_and_postorder_traversal;

import com.common.datastructure.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreePreorderAndPostorderTraversal {
    Map<Integer, Integer> postorderIndexMap; // A HashMap to store the index of each element in the post-order traversal array
    int preorderIndex; // A variable to keep track of the current index in the pre-order traversal array

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        postorderIndexMap = new HashMap<>();
        preorderIndex = 0;

        // Store the index of each element in the post-order traversal array in the HashMap
        for (int i = 0; i < postorder.length; i++) {
            postorderIndexMap.put(postorder[i], i);
        }

        // Call the recursive function to construct the binary tree
        return buildTreeHelper(0, postorder.length - 1, preorder, postorder);
    }

    private TreeNode buildTreeHelper(int postorderStart, int postorderEnd, int[] preorder, int[] postorder) {
        // Base case: if the start index is greater than the end index, return null
        if (postorderStart > postorderEnd) return null;

        // The root of the current subtree is the current element in preorder, from preorderIndex
        int rootValue = preorder[preorderIndex++];
        TreeNode root = new TreeNode(rootValue);

        // If the start and end index are equal, the current subtree only has one node (the root)
        if (postorderStart == postorderEnd) return root;

        // Find the index of the root in the post-order traversal array using the HashMap
        int postorderIndex = postorderIndexMap.get(preorder[preorderIndex]);

        // Recursively construct the left and right subtrees of the root node
        root.left = buildTreeHelper(postorderStart, postorderIndex, preorder, postorder);
        root.right = buildTreeHelper(postorderIndex + 1, postorderEnd - 1, preorder, postorder);

        // Return the root of the current subtree
        return root;
    }
}

