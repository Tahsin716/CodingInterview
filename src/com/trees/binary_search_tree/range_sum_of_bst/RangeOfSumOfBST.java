package com.trees.binary_search_tree.range_sum_of_bst;

import com.common.datastructure.TreeNode;

public class RangeOfSumOfBST {
    public int rangeSumBST(TreeNode root, int low, int high) {
        // If the root is null, return 0.
        if (root == null) return 0;

        // Initialize a variable for the sum of values.
        int sum = 0;

        // If the root's value falls within the given range, add it to the sum.
        if (low <= root.val && root.val <= high) sum += root.val;

        // If the root's value is greater than or equal to the low end of the range,
        // recursively traverse the left subtree to look for values within the range.
        if (low <= root.val) sum += rangeSumBST(root.left, low, high);

        // If the root's value is less than or equal to the high end of the range,
        // recursively traverse the right subtree to look for values within the range.
        if (root.val <= high) sum += rangeSumBST(root.right, low, high);

        // Return the sum of values that fall within the given range.
        return sum;
    }
}

