package com.trees.binary_tree.all_nodes_distance_k_in_binary_tree;

import com.common.datastructure.TreeNode;

import java.util.*;

public class AllNodesDistanceKInBinaryTree {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        // Initialize variables
        List<Integer> result = new ArrayList<>();
        Map<TreeNode, TreeNode> map = new HashMap<>();
        Set<TreeNode> set = new HashSet<>();

        // If the root is null, return the empty list
        if (root == null) return result;

        // Map each node to its parent node
        mapNodeToParent(root, map);

        // Traverse the tree from the target node and collect nodes at a distance k
        dfs(target, map, set, result, k);

        return result;
    }

    // This method maps each node to its parent node
    private void mapNodeToParent(TreeNode root, Map<TreeNode, TreeNode> map) {
        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);
        map.put(root, null);

        while (!queue.isEmpty()) {
            TreeNode top = queue.poll();

            if (top.left != null) {
                queue.offer(top.left);
                map.put(top.left, top);
            }

            if (top.right != null) {
                queue.offer(top.right);
                map.put(top.right, top);
            }
        }
    }

    // This method traverses the tree from the target node and collects nodes at a distance k
    private void dfs(TreeNode node, Map<TreeNode, TreeNode> map, Set<TreeNode> set, List<Integer> result, int k) {
        // If the node is null or the distance is less than 0, return
        if (node == null || k < 0) return;

        // Add the node to the set
        set.add(node);

        // If the distance is 0, add the node's value to the result and return
        if (k == 0) {
            result.add(node.val);
            return;
        }

        // Traverse the parent, left, and right nodes and add nodes at a distance k to the result
        TreeNode parentNode = map.get(node);
        TreeNode leftNode = node.left;
        TreeNode rightNode = node.right;

        if (parentNode != null && !set.contains(parentNode)) dfs(parentNode, map, set, result, k - 1);
        if (leftNode != null && !set.contains(leftNode)) dfs(leftNode, map, set, result, k - 1);
        if (rightNode != null && !set.contains(rightNode)) dfs(rightNode, map, set, result, k - 1);
    }
}

