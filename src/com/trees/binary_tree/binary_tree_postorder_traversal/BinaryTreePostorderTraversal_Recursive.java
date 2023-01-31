package com.trees.binary_tree.binary_tree_postorder_traversal;

import com.common.datastructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePostorderTraversal_Recursive {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        if (root == null)
            return list;

        dfs(root, list);

        return list;
    }

    public void dfs(TreeNode root, List<Integer> list) {
        if (root != null) {
            dfs(root.left, list);
            dfs(root.right, list);
            list.add(root.val);
        }
    }
}
