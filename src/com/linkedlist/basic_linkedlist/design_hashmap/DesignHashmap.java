package com.linkedlist.basic_linkedlist.design_hashmap;

public class DesignHashmap {
    private static class MyHashMap {
        static final int SIZE = 19997; // The size of the hash table
        static final int MULTIPLIER = 12582917; // A prime number used for hashing
        ListNode[] bucket; // An array of linked lists to store key-value pairs

        public MyHashMap() {
            bucket = new ListNode[SIZE]; // Initialize the array of linked lists
        }

        // Adds the key-value pair to the hash table
        public void put(int key, int value) {
            remove(key); // Remove the key if it already exists
            int hashedIndex = hash(key); // Calculate the index of the bucket

            // Add the new key-value pair to the front of the linked list
            ListNode node = new ListNode(key, value, bucket[hashedIndex]);
            bucket[hashedIndex] = node;
        }

        // Gets the value associated with the key, or -1 if the key is not found
        public int get(int key) {
            int hashedIndex = hash(key); // Calculate the index of the bucket
            ListNode node = bucket[hashedIndex]; // Get the linked list at the bucket

            // Traverse the linked list to find the key
            while (node != null) {
                if (node.key == key) return node.val; // Return the value if the key is found
                node = node.next;
            }

            return -1; // Return -1 if the key is not found
        }

        // Removes the key-value pair from the hash table
        public void remove(int key) {
            int hashedIndex = hash(key); // Calculate the index of the bucket
            ListNode node = bucket[hashedIndex]; // Get the linked list at the bucket

            if (node == null) return; // Return if the linked list is empty

            // If the first node in the linked list matches the key, remove it
            if (node.key == key) {
                bucket[hashedIndex] = node.next;
            } else {
                // Traverse the linked list to find the key and remove it
                while (node.next != null) {
                    if (node.next.key == key) {
                        node.next = node.next.next;
                        return;
                    }
                    node = node.next;
                }
            }
        }

        // Hashes the key to get an index in the range [0, SIZE)
        private int hash(int key) {
            return (int)((long)key * MULTIPLIER % SIZE);
        }

    }

    // A node in the linked list
    private static class ListNode {
        int key, val;
        ListNode next;

        public ListNode(int key, int val, ListNode next) {
            this.key = key;
            this.val = val;
            this.next = next;
        }
    }
}
