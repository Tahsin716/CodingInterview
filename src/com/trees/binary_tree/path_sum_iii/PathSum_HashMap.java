package com.trees.binary_tree.path_sum_iii;

import com.common.datastructure.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class PathSum_HashMap {
    public int pathSum(TreeNode root, int sum) {
        // create a hashmap to keep track of the cumulative sum and the number of paths
        Map<Long, Integer> map = new HashMap<>();
        // initialize the hashmap with the cumulative sum of 0 and a count of 1 (the empty path)
        map.put((long)0, 1);

        // call the helper function with the root node, the current sum, the target sum, and the hashmap
        return helper(root, 0, sum, map);
    }

    private int helper(TreeNode node, long currSum, int target, Map<Long, Integer> map) {
        // if the node is null, there are no paths from this node
        if (node == null) {
            return 0;
        }

        // update the current sum with the value of the current node
        currSum += node.val;
        // get the number of paths that sum up to the target by subtracting the target from the current sum
        // if the difference exists in the hashmap, add the number of paths that sum up to the difference
        int numPaths = map.getOrDefault(currSum - target, 0);
        // add the current cumulative sum to the hashmap and update the count
        map.put(currSum, map.getOrDefault(currSum, 0) + 1);

        // recursively count the number of paths in the left and right subtrees that sum up to the target
        numPaths += helper(node.left, currSum, target, map);
        numPaths += helper(node.right, currSum, target, map);

        // remove the current cumulative sum from the hashmap to backtrack
        map.put(currSum, map.get(currSum) - 1);

        // return the total number of paths
        return numPaths;
    }
}

