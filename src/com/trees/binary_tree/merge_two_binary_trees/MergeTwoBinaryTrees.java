package com.trees.binary_tree.merge_two_binary_trees;

import com.common.datastructure.TreeNode;

public class MergeTwoBinaryTrees {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        // If root1 is null, the merged tree is just root2.
        if (root1 == null) return root2;

        // If root2 is null, the merged tree is just root1.
        if (root2 == null) return root1;

        // If both roots are not null, add their values and assign it to root1.
        root1.val += root2.val;

        // Recursively merge the left and right subtrees of the two roots.
        root1.left = mergeTrees(root1.left, root2.left);
        root1.right = mergeTrees(root1.right, root2.right);

        // Return the merged tree.
        return root1;
    }
}

