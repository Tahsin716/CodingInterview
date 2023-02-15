package com.trees.binary_search_tree.largest_bst_in_a_bt;

public class LargestBinarySearchTreeInABinaryTree {
    public static int largestBST(TreeNode<Integer> root) {
        NodeData data = dfs(root);
        return data.maxSize;
    }

    private static NodeData dfs(TreeNode<Integer> node) {
        if (node == null) return new NodeData(0, Integer.MIN_VALUE, Integer.MAX_VALUE);

        // Post order traversal, to compute all the child nodes first
        NodeData leftNodeData = dfs(node.left);
        NodeData rightNodeData = dfs(node.right);
        NodeData currentNodeData = new NodeData();

        if (node.data > leftNodeData.maxNodeValue && node.data < rightNodeData.minNodeValue) {
            currentNodeData.maxSize = leftNodeData.maxSize + rightNodeData.maxSize + 1;

            // When node == null, we are returning minNodeValue as +INF and maxNodeValue as -INF
            // that's why we need to check for the max and min value of left and right NodeData
            currentNodeData.minNodeValue = Math.min(node.data, leftNodeData.minNodeValue);
            currentNodeData.maxNodeValue = Math.max(node.data, rightNodeData.maxNodeValue);

        } else {
            currentNodeData.maxSize = Math.max(leftNodeData.maxSize, rightNodeData.maxSize);
            currentNodeData.minNodeValue = Integer.MIN_VALUE;
            currentNodeData.maxNodeValue = Integer.MAX_VALUE;
        }

        return currentNodeData;
    }

    private static class NodeData {
        public int maxSize, maxNodeValue, minNodeValue;

        public NodeData() {

        }
        public NodeData(int maxSize, int maxNodeValue, int minNodeValue) {
            this.maxSize = maxSize;
            this.maxNodeValue = maxNodeValue;
            this.minNodeValue = minNodeValue;
        }
    }

    private static class TreeNode<T> {
        public T data;
        public TreeNode<T> left;
        public TreeNode<T> right;

        TreeNode(T data) {
            this.data = data;
            left = null;
            right = null;
        }
    }
}
