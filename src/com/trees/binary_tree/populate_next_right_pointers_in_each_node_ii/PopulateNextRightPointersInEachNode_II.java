package com.trees.binary_tree.populate_next_right_pointers_in_each_node_ii;

import java.util.LinkedList;
import java.util.Queue;

public class PopulateNextRightPointersInEachNode_II {
    public Node connect(Node root) {
        // Check if the tree is empty
        if (root == null) {
            return null;
        }

        // Create a queue to store the nodes at each level
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        // Traverse the tree level by level
        while (!queue.isEmpty()) {
            int level = queue.size();

            // Connect each node in the current level to its right neighbor
            for (int i = 0; i < level; i++) {
                Node top = queue.poll();

                if (top.left != null) {
                    queue.add(top.left);
                }
                if (top.right != null) {
                    queue.add(top.right);
                }

                // Connect the current node to its right neighbor
                if (i == level - 1) {
                    top.next = null;
                } else {
                    top.next = queue.peek();
                }
            }
        }

        return root;
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

