package com.trees.binary_search_tree.convert_sorted_array_to_bst;

import com.common.datastructure.TreeNode;

public class ConvertSortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        return createBST(nums, 0, nums.length - 1);
    }

    private TreeNode createBST(int[] nums, int start, int end) {
        // Base case: if start is greater than end, return null.
        if (start > end)
            return null;

        // Find the middle index of the array.
        int mid = start + (end - start) / 2;

        // Create a new TreeNode with the middle value.
        TreeNode node = new TreeNode(nums[mid]);

        // Recursively create the left and right subtrees.
        node.left = createBST(nums, start, mid - 1);
        node.right = createBST(nums, mid + 1, end);

        return node;
    }
}

