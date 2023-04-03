package com.trees.binary_tree.populate_next_right_pointers_in_each_node;

import java.util.LinkedList;
import java.util.Queue;

public class PopulateNextRightPointersInEachNode {
    public Node connect(Node root) {
        if (root == null)
            return null;

        // Create a queue to store the nodes at each level of the tree
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        // While there are nodes in the queue, process each level
        while(!queue.isEmpty()) {
            int currentLevelSize = queue.size(); // Get the number of nodes in the current level

            // Iterate over each node in the current level
            for (int i = 0; i < currentLevelSize; i++) {
                Node top = queue.poll(); // Get the next node in the queue

                // Add the left and right child nodes of the current node to the queue
                if (top.left != null)
                    queue.add(top.left);

                if (top.right != null)
                    queue.add(top.right);

                // If the current node is the last node in the level, set its next pointer to null
                if (i == currentLevelSize - 1) {
                    top.next = null;
                }
                // Otherwise, set its next pointer to the next node in the queue
                else {
                    top.next = queue.peek();
                }
            }
        }

        return root; // Return the updated root of the binary tree
    }

    private class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}

