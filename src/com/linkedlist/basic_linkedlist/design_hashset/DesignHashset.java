package com.linkedlist.basic_linkedlist.design_hashset;

public class DesignHashset {
    private static class MyHashSet {
        // The size of the bucket array.
        static final int SIZE = 19997;

        // A multiplier used to compute hash codes. This should be a prime number to minimize collisions.
        static final int MULTIPLIER = 12582917;

        // The bucket array that will hold the linked list of nodes.
        ListNode[] bucket;

        // Constructor to create a new hash set.
        public MyHashSet() {
            // Initialize the bucket array with null values.
            bucket = new ListNode[SIZE];
        }

        // Method to add a key to the hash set.
        public void add(int key) {
            // If the key is already in the hash set, do nothing.
            if (contains(key)) return;

            // Compute the hash code for the key.
            int hashedIndex = hash(key);

            // Create a new node with the key and add it to the front of the linked list at the hashed index.
            ListNode node = new ListNode(key, bucket[hashedIndex]);
            bucket[hashedIndex] = node;
        }

        // Method to remove a key from the hash set.
        public void remove(int key) {
            // If the key is not in the hash set, do nothing.
            if (!contains(key)) return;

            // Compute the hash code for the key.
            int hashedIndex = hash(key);

            // Get the head of the linked list at the hashed index.
            ListNode node = bucket[hashedIndex];

            // If the head node has the key, remove it by updating the bucket array.
            if (node.key == key) {
                bucket[hashedIndex] = node.next;
            } else {
                // Otherwise, iterate through the linked list and remove the node that has the key.
                while (node.next != null) {
                    if (node.next.key == key) {
                        node.next = node.next.next;
                        return;
                    }
                    node = node.next;
                }
            }
        }

        // Method to check if the hash set contains a key.
        public boolean contains(int key) {
            // Compute the hash code for the key.
            int hashedIndex = hash(key);

            // Get the head of the linked list at the hashed index.
            ListNode node = bucket[hashedIndex];

            // Iterate through the linked list and check if any node has the key.
            while (node != null) {
                if (node.key == key) return true;

                node = node.next;
            }

            return false;
        }

        // Method to compute the hash code for a key.
        private int hash(int key) {
            // Multiply the key by the multiplier and take the remainder with respect to the size of the bucket array.
            return (int)((long)key * MULTIPLIER % SIZE);
        }

        // The ListNode class represents a node in the linked list.
        private static class ListNode {
            int key;
            ListNode next;

            ListNode(int key) {
                this.key = key;
            }

            ListNode(int key, ListNode next) {
                this.key = key;
                this.next = next;
            }
        }
    }
}

