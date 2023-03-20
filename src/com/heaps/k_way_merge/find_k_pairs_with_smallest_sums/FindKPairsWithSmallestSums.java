package com.heaps.k_way_merge.find_k_pairs_with_smallest_sums;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class FindKPairsWithSmallestSums {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {

        List<List<Integer>> pairs = new ArrayList<>();

        // if any of the input array is empty or k is 0, return empty list
        if (nums1.length == 0 || nums2.length == 0 || k == 0) {
            return pairs;
        }

        // create a priority queue with a custom comparator function
        // that compares two pairs by their sum of elements
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((arr1, arr2) -> arr1[0] + arr1[1] - arr2[0] - arr2[1]);

        // add the first k pairs to the priority queue
        // and 0, as only first index is used for nums2
        for (int i = 0; i < nums1.length && i < k; i++) {
            minHeap.offer(new int[] {nums1[i], nums2[0], 0});
        }

        // poll k times from the priority queue to get the k smallest, pairs
        while (k-- != 0 && !minHeap.isEmpty()) {
            int[] current = minHeap.poll();
            int num1 = current[0];
            int num2 = current[1];
            int num2Index = current[2];

            pairs.add(List.of(num1, num2));

            // if nums2 array has more elements, add the next pair to the priority queue
            if (num2Index + 1 < nums2.length) {
                minHeap.offer(new int[]{num1, nums2[num2Index + 1], num2Index + 1});
            }
        }

        // return the list of k smallest, pairs
        return pairs;
    }
}

