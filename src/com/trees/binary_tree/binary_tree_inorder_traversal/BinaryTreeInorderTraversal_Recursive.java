package com.trees.binary_tree.binary_tree_inorder_traversal;

import com.common.datastructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal_Recursive {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        if (root == null)
            return list;

        dfs(root, list);

        return list;
    }

    public void dfs(TreeNode root, List<Integer> list) {
        // Inorder -> left - root - right
        if (root != null) {
            dfs(root.left, list);
            list.add(root.val);
            dfs(root.right, list);
        }
    }
}
