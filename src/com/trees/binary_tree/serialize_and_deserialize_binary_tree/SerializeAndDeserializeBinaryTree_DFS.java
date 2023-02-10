package com.trees.binary_tree.serialize_and_deserialize_binary_tree;

import com.common.datastructure.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndDeserializeBinaryTree_DFS {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return serializeHelper(root, new StringBuilder()).toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        return deserializeHelper(new LinkedList<>(Arrays.asList(data.split(","))));
    }

    private StringBuilder serializeHelper(TreeNode node, StringBuilder builder) {
        if (node == null) return builder.append("#");

        builder.append(node.val).append(",");
        serializeHelper(node.left, builder).append(",");
        serializeHelper(node.right, builder);

        return builder;
    }

    private TreeNode deserializeHelper(Queue<String> queue) {
        String val = queue.poll();

        if (val.equals("#")) return null;

        TreeNode node = new TreeNode(Integer.parseInt(val));
        node.left = deserializeHelper(queue);
        node.right = deserializeHelper(queue);

        return node;
    }
}
