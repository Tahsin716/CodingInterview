package com.trees.binary_tree.binary_tree_left_side_view;

import com.common.datastructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeLeftSideView {
    public List<Integer> leftSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        if (root == null)
            return list;

        dfs(root, list, 0);

        return list;
    }

    // Perform a preorder traversal: root -> left -> right
    public void dfs(TreeNode node, List<Integer> list, int height) {
        if (node == null)
            return;

        // If height == list.size() that means it is the left most node of that level
        // so insert it into the ans list
        if (height == list.size())
            list.add(node.val);

        dfs(node.left, list, height + 1);
        dfs(node.right, list, height + 1);
    }
}
