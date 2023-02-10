package com.trees.binary_tree.children_sum_property;

public class ChildrenSumProperty {
    public void changeTree(BinaryTreeNode < Integer > root) {
        if (root == null) return;

        int sum = 0;

        if (root.left != null) sum += root.left.data;
        if (root.right != null) sum += root.right.data;

        // If the sum of both left node and right node is less than current node
        // then update both child nodes value with current node's value
        if (root.data > sum) {
            if (root.left != null) root.left.data = root.data;
            if (root.right != null) root.right.data = root.data;
        }

        changeTree(root.left);
        changeTree(root.right);


        // If no child node exists then return, else update current node's value
        // with the sum of left child node and right child node's value
        if (root.left == null && root.right == null) return;

        sum = 0;

        if (root.left != null) sum += root.left.data;
        if (root.right != null) sum += root.right.data;

        root.data = sum;

    }

    private class BinaryTreeNode<Integer> {
        int data;
        BinaryTreeNode<Integer> left;
        BinaryTreeNode<Integer> right;

        public BinaryTreeNode(int data) {
            this.data = data;
        }
    }
}
