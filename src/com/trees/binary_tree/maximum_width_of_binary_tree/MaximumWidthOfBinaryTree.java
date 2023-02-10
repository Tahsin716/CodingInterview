package com.trees.binary_tree.maximum_width_of_binary_tree;

import com.common.datastructure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumWidthOfBinaryTree {
    // MaxWidth = total number of nodes in a level between 2 nodes
    // so basically width of a level = (lastNodeIndex of current level) - (firstNodeIndex of current level) + 1
    // index of node is found from the binary tree property: leftNodeIndex = 2 * i + 1, rightNodeIndex = 2 * i + 2
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;

        int maxWidth = 0;
        Queue<Pair> queue = new LinkedList<>();

        queue.offer(new Pair(root, 0));

        while (!queue.isEmpty()) {
            int currentLevelNodeCount = queue.size();

            // For indexing of a binary tree, if we just use the property
            // leftNodeIndex = 2 * i + 1
            // rightNodeIndex = 2 * i + 2
            // There is a problem, if we use the above binary tree property for numbering nodes; if the tree is skewed
            // then there will be an overflow. So what we can do is subtract all the node's indices of a level, with
            // the index of the level's first node
            int currentLevelFirstNodeIndex = queue.peek().index;

            int firstNodeIndex = 0, lastNodeIndex = 0;

            for (int i = 0; i < currentLevelNodeCount; i++) {
                Pair top = queue.poll();
                top.index = top.index - currentLevelFirstNodeIndex;

                if (i == 0) {
                    firstNodeIndex = top.index;
                }

                if (i == currentLevelNodeCount - 1) {
                    lastNodeIndex = top.index;
                }

                if (top.node.left != null) {
                    queue.offer(new Pair(top.node.left, 2 * top.index + 1));
                }

                if (top.node.right != null) {
                    queue.offer(new Pair(top.node.right, 2 * top.index + 2));
                }
            }

            int currentLevelWidth = lastNodeIndex - firstNodeIndex + 1;
            maxWidth = Math.max(maxWidth, currentLevelWidth);
        }

        return maxWidth;
    }

    private class Pair {
        TreeNode node;
        int index;

        public Pair(TreeNode node, int index) {
            this.node = node;
            this.index = index;
        }
    }
}
