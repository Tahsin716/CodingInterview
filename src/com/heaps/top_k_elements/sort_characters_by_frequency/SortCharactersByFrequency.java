package com.heaps.top_k_elements.sort_characters_by_frequency;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class SortCharactersByFrequency {
    public String frequencySort(String s) {
        // Keep character frequency/count in map
        Map<Character, Integer> map = new HashMap<>();
        // Keep Map.Entry PriorityQueue to form a maxHeap, i.e.
        // character with higher frequency will be at the top of the heap
        PriorityQueue<Map.Entry<Character, Integer>> maxHeap =
                new PriorityQueue<>((current, next) -> next.getValue() - current.getValue());

        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            maxHeap.offer(entry);
        }

        StringBuilder stringBuilder = new StringBuilder();

        while (!maxHeap.isEmpty()) {
            Map.Entry<Character, Integer> entry = maxHeap.poll();
            int count = entry.getValue();

            // Poll the elements(Map.Entry) from the maxHeap,
            // And append the total number(count) of characters(entry.getKey())
            // in the StringBuilder
            while (count > 0) {
                stringBuilder.append(entry.getKey());
                count--;
            }
        }

        return stringBuilder.toString();
    }
}
