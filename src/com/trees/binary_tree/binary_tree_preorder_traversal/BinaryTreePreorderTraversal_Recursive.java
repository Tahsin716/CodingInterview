package com.trees.binary_tree.binary_tree_preorder_traversal;

import com.common.datastructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePreorderTraversal_Recursive {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        if (root == null)
            return list;

        dfs(root, list);

        return list;
    }

    public void dfs(TreeNode root, List<Integer> list) {
        if (root != null) {
            // Preorder -> root - left - right
            list.add(root.val);
            dfs(root.left, list);
            dfs(root.right, list);
        }
    }
}
