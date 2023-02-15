package com.trees.binary_search_tree.construct_bst_from_preorder_traversal;

import com.common.datastructure.TreeNode;

public class ConstructBinarySearchTreeFromPreorderTraversal {
    int index = 0;
    public TreeNode bstFromPreorder(int[] preorder) {
        // Similar to validate binary search tree, but we only need the max limit
        return dfs(preorder, Integer.MAX_VALUE);
    }

    private TreeNode dfs(int[] preorder, int max) {
        if (index > preorder.length - 1 || preorder[index] > max) return null;

        TreeNode node = new TreeNode(preorder[index++]);
        node.left = dfs(preorder, node.val);
        node.right = dfs(preorder, max);

        return node;
    }
}
