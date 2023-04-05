package com.binarysearch.time_based_key_value_store;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TimeBasedKeyValueStore {
    class TimeMap {
        HashMap<String, List<Node>> map;

        public TimeMap() {
            map = new HashMap<>();
        }

        public void set(String key, String value, int timestamp) {
            map.putIfAbsent(key, new ArrayList<>());

            map.get(key).add(new Node(timestamp, value));
        }

        public String get(String key, int timestamp) {
            if (!map.containsKey(key)) return "";

            // Perform binary search to get the floor element (the greatest element which is smaller than target)
            // for the given key and timestamp
            return binarySearchNode(key, timestamp);
        }

        private String binarySearchNode(String key, int timestamp) {
            List<Node> nodes = map.get(key);
            int start = 0, end = nodes.size() - 1, mid;
            String ans = "";

            // If element with given timestamp exists, then return its value
            // Otherwise find the floor(the greatest element which is smaller than target) of given timestamp
            while (start <= end) {
                mid = start + (end - start) / 2;

                Node current = nodes.get(mid);

                if (current.timestamp == timestamp) return current.value;

                // Floor element of given timestamp
                if (current.timestamp < timestamp) {
                    ans = current.value;
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }

            return ans;
        }
    }

    class Node {
        int timestamp;
        String value;

        public Node(int timestamp, String value) {
            this.timestamp = timestamp;
            this.value = value;
        }
    }
}
