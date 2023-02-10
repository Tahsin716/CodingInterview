package com.trees.binary_tree.binary_tree_right_side_view;

import com.common.datastructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        if (root == null)
            return list;

        dfs(root, list, 0);

        return list;
    }

    // Perform a reverse preorder traversal: root -> right -> left
    public void dfs(TreeNode node, List<Integer> list, int height) {
        if (node == null)
            return;

        // If height == list.size() that means it is the right most node of that level
        // so insert it into the ans list
        if (height == list.size())
            list.add(node.val);

        dfs(node.right, list, height + 1);
        dfs(node.left, list, height + 1);
    }
}
