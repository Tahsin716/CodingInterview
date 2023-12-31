package com.trees.binary_tree.construct_binary_tree_from_inorder_and_postorder_traversal;

import com.common.datastructure.TreeNode;

import java.util.HashMap;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // Map the inorder traversal node value with their indices
        // so that we can find the inorder root in O(1)
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) map.put(inorder[i], i);

        return buildTreeHelper(postorder, map, postorder.length - 1 , 0, inorder.length - 1);
    }

    public TreeNode buildTreeHelper(int[] postorder, HashMap<Integer, Integer> map, int postStart, int inorderStart, int inorderEnd) {
        if (postStart > postorder.length - 1 || inorderStart > inorderEnd)
            return null;

        int rootValue = postorder[postStart];
        TreeNode root = new TreeNode(rootValue);

        // Get the root index inorder traversal
        int inorderRoot = map.get(rootValue);

        // Number of nodes in left subtree,
        int nodesInLeftSubtree = inorderRoot - inorderEnd;


        // postStart = postStart + nodesInLeftSubtree - 1
        // inorderStart = inorderStart
        // inorderEnd = inRoot - 1
        root.left = buildTreeHelper(postorder, map, postStart + nodesInLeftSubtree - 1, inorderStart, inorderRoot - 1);

        // postStart = postStart - 1
        // inorderStart = inRoot + 1
        // inorderEnd = inorderEnd
        root.right = buildTreeHelper(postorder, map, postStart - 1, inorderRoot + 1, inorderEnd);

        return root;
    }
}
