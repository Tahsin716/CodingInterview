package com.trees.binary_tree.construct_binary_tree_from_inorder_and_preorder_traversal;

import com.common.datastructure.TreeNode;

import java.util.HashMap;

public class ConstructBinaryTreeFromInorderAndPreorderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // Map the inorder traversal node value with their indices
        // so that we can find the inorder root in O(1)
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) map.put(inorder[i], i);

        TreeNode ans = buildTreeHelper(preorder, map, 0, 0, preorder.length - 1);

        return ans;
    }

    private TreeNode buildTreeHelper(int[] preorder, HashMap<Integer, Integer> map, int preorderStart, int inorderStart, int inorderEnd) {
        if (preorderStart > preorder.length - 1 || inorderStart > inorderEnd) return null;

        int rootValue = preorder[preorderStart];
        TreeNode root = new TreeNode(rootValue);

        // Get the root index inorder traversal
        int inorderRoot = map.get(rootValue);

        // Number of nodes in left subtree,
        int nodesInLeftSubtree = inorderRoot - inorderStart;

        // preStart = preStart
        // preEnd = preStart + nodesInLeftSubtree
        // inStart = inStart
        // inEnd = inRoot - 1
        root.left = buildTreeHelper(preorder, map, preorderStart + 1, inorderStart, inorderRoot - 1);

        // preStart = preStart + nodesInLeftSubtree + 1
        // preEnd = preEnd
        // inStart = inRoot + 1
        // inEnd = inEnd
        root.right = buildTreeHelper(preorder, map, preorderStart + nodesInLeftSubtree + 1, inorderRoot + 1, inorderEnd);

        return root;
    }
}
