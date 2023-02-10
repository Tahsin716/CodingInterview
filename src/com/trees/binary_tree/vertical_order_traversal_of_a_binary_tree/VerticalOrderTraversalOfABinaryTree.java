package com.trees.binary_tree.vertical_order_traversal_of_a_binary_tree;

import com.common.datastructure.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class VerticalOrderTraversalOfABinaryTree {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        // Map with {key: column, value : {key : row, value: PriorityQueue<>(node.value)}}
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        // Tuple to keep track of TreeNode and its row and column value
        Tuple rootNodeTuple = new Tuple(root, 0, 0);

        // Perform dfs to map node values with their row and column
        dfs(rootNodeTuple, map);

        List<List<Integer>> result = new ArrayList<>();

        // Iterate the maps for every column
        for (TreeMap<Integer, PriorityQueue<Integer>> mapValues : map.values()) {
            List<Integer> currentNodeValues = new ArrayList<>();

            // Iterate the PriorityQueues for every row
            for (PriorityQueue<Integer> nodeValues : mapValues.values()) {
                while (!nodeValues.isEmpty()) {
                    currentNodeValues.add(nodeValues.poll());
                }
            }

            result.add(currentNodeValues);
        }

        return result;
    }

    private void dfs(Tuple tuple, TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map) {
        if (tuple.node == null) return;

        // Create a map if a column does not exist
        map.putIfAbsent(tuple.column, new TreeMap<>());
        // Create a map if the row does not exist
        map.get(tuple.column).putIfAbsent(tuple.row, new PriorityQueue<>());

        // put the node value for the column and row
        map.get(tuple.column).get(tuple.row).offer(tuple.node.val);

        // Create tuple for left and right node with their corresponding column and row
        Tuple leftNodeTuple = new Tuple(tuple.node.left, tuple.row + 1, tuple.column - 1);
        Tuple rightNodeTuple = new Tuple(tuple.node.right, tuple.row + 1, tuple.column + 1);

        // call dfs for left and right node tuple
        dfs(leftNodeTuple, map);
        dfs(rightNodeTuple, map);
    }

    private class Tuple {
        int row, column;
        TreeNode node;

        public Tuple(TreeNode node, int row, int column) {
            this.node = node;
            this.row = row;
            this.column = column;
        }
    }
}
