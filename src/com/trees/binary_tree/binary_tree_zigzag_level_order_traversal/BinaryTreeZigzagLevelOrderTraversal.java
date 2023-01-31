package com.trees.binary_tree.binary_tree_zigzag_level_order_traversal;

import com.common.datastructure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        LinkedList<Integer> currentLevel;

        if (root == null) return result;

        // use boolean isEvenLevel to keep track of whether the tree level is even or not
        // so that we know whether to insert element at front or from back
        boolean isEvenLevel = false;
        queue.offer(root);

        while (!queue.isEmpty()) {
            // Get the number of nodes in current level
            int currentLevelNodeCount = queue.size();
            currentLevel = new LinkedList<>();

            // Iterate the nodes in current level
            for (int i = 0; i < currentLevelNodeCount; i++) {
                TreeNode top = queue.poll();

                if (top.left != null) queue.offer(top.left);

                if (top.right != null) queue.offer(top.right);

                // If the level is even, then add elements at front so that last element is at first
                // else add element at last, so that first element is at the front
                if (isEvenLevel) {
                    currentLevel.addFirst(top.val);
                } else {
                    currentLevel.addLast(top.val);
                }
            }

            isEvenLevel = !isEvenLevel;

            result.add(currentLevel);
        }

        return result;
    }
}
