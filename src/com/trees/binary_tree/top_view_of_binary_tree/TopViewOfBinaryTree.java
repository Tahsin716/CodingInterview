package com.trees.binary_tree.top_view_of_binary_tree;

import java.util.*;

public class TopViewOfBinaryTree {
    public static ArrayList<Integer> getTopView(BinaryTreeNode root) {
        if (root == null) return new ArrayList<>();

        Queue<Pair> queue = new LinkedList<>();
        ArrayList<Integer> result = new ArrayList<>();
        Map<Integer, Integer> map = new TreeMap<>();
        queue.add(new Pair(root, 0));

        while(!queue.isEmpty()){
            Pair top = queue.poll();

            // Since we are performing a level order traversal, if current column already exists
            // that means the top node for the current column is present in the map, so we won't update it.
            if(!map.containsKey(top.column)) {
                map.put(top.column, top.node.val);
            }

            if(top.node.left != null) {
                queue.add(new Pair(top.node.left, top.column - 1));
            }

            if(top.node.right != null) {
                queue.add(new Pair(top.node.right, top.column + 1));
            }
        }

        for(Integer value: map.values()){
            result.add(value);
        }

        return result;
    }


    private static class Pair {
        int column;
        BinaryTreeNode node;

        public Pair(BinaryTreeNode node, int column){
            this.node = node;
            this.column = column;
        }
    }

    private class BinaryTreeNode {
        int val;
        BinaryTreeNode left;
        BinaryTreeNode right;

        BinaryTreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }
}
