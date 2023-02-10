package com.trees.binary_tree.serialize_and_deserialize_binary_tree;

import com.common.datastructure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndDeserializeBinaryTree_BFS {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return serializeHelper(root, new StringBuilder());
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        return deserializeHelper(data);
    }

    private String serializeHelper(TreeNode root, StringBuilder builder) {
        if (root == null) return builder.append('#').toString();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        builder.append(root.val).append(',');

        while (!queue.isEmpty()) {
            TreeNode top = queue.poll();

            if (top.left == null) {
                builder.append('#').append(',');
            } else {
                builder.append(top.left.val).append(',');
                queue.offer(top.left);
            }

            if (top.right == null) {
                builder.append('#').append(',');
            } else {
                builder.append(top.right.val).append(',');
                queue.offer(top.right);
            }

        }

        return builder.toString();
    }

    private TreeNode deserializeHelper(String data) {
        if (data.equals("#")) return null;

        String[] nodes = data.split(",");
        int index = 0;

        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(nodes[index]));

        queue.offer(root);
        index++;

        while (!queue.isEmpty()) {
            TreeNode top = queue.poll();

            if (nodes[index].equals("#")) {
                top.left = null;
            } else {
                top.left = new TreeNode(Integer.parseInt(nodes[index]));
                queue.offer(top.left);
            }

            index++;

            if (nodes[index].equals("#")) {
                top.right = null;
            } else {
                top.right = new TreeNode(Integer.parseInt(nodes[index]));
                queue.offer(top.right);
            }

            index++;
        }

        return root;
    }
}
