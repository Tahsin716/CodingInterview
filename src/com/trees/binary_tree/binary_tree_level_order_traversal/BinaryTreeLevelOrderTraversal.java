package com.trees.binary_tree.binary_tree_level_order_traversal;

import com.common.datastructure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentLevel;

        if (root == null) return result;

        queue.add(root);

        while (!queue.isEmpty()) {
            // Find the total number of nodes in current level of tree
            int currentLevelNodeCount = queue.size();
            // new array list to insert the nodes of current level
            currentLevel = new ArrayList<>();

            // Iterate the total nodes in current level
            for (int i = 0; i < currentLevelNodeCount; i++) {
                TreeNode top = queue.poll();

                // Insert the child nodes in queue if they are not null
                if (top.left != null) queue.add(top.left);
                if (top.right != null) queue.add(top.right);

                // insert current node in the current level answer list
                currentLevel.add(top.val);
            }

            result.add(currentLevel);
        }

        return result;
    }
}
