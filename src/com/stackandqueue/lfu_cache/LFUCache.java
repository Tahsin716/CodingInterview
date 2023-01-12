package com.stackandqueue.lfu_cache;

import java.util.HashMap;
import java.util.Map;

public class LFUCache {
    Map<Integer, Node> map;
    Map<Integer, DoublyLinkedList> countMap;
    final int capacity;
    int minFrequency;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>(capacity);
        this.countMap = new HashMap<>(capacity);
        this.minFrequency = 0;
    }

    public int get(int key) {
        Node node = map.get(key);

        if (node == null) return -1;

        updateFrequencyMap(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (capacity == 0) return;

        Node node = map.get(key);

        if (node == null) {
            if (map.size() == capacity) {
                DoublyLinkedList doublyLinkedList = countMap.get(minFrequency);
                Node leastFrequentNode = doublyLinkedList.getLast();
                map.remove(leastFrequentNode.key);
                doublyLinkedList.removeLast();
            }

            Node newNode = new Node(key, value);
            map.put(newNode.key, newNode);

            minFrequency = 1;

            countMap.putIfAbsent(minFrequency, new DoublyLinkedList());
            countMap.get(minFrequency).addFirst(newNode);
        } else {
            node.value = value;
            updateFrequencyMap(node);
        }
    }

    private void updateFrequencyMap(Node node) {
        DoublyLinkedList doublyLinkedList = countMap.get(node.count);
        doublyLinkedList.remove(node);

        // The element we removed happened to be the least recently used(LRU) element of the minFrequency
        // No more element exists of the minFrequency, so we increment minFrequency
        if (doublyLinkedList.size() == 0 && minFrequency == node.count) minFrequency++;

        node.incrementCount();
        countMap.putIfAbsent(node.count, new DoublyLinkedList());
        countMap.get(node.count).addFirst(node);
    }

    private class Node {
        int key, value, count;
        Node prev, next;

        public Node() {

        }

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.count = 1;
        }

        public void incrementCount() {
            this.count++;
        }
    }
    private class DoublyLinkedList {
        private final Node head;
        private final Node tail;
        private int size;

        public DoublyLinkedList() {
            head = new Node();
            tail = new Node();
            head.next = tail;
            tail.prev = head;
            size = 0;
        }

        public void addFirst(Node node) {
            Node currentFirst = head.next;
            head.next = node;
            node.prev = head;
            node.next = currentFirst;
            currentFirst.prev = node;
            size++;
        }

        public void remove(Node node) {
            Node prevNode = node.prev;
            Node nextNode = node.next;
            prevNode.next = nextNode;
            nextNode.prev = prevNode;
            size--;
        }

        public Node getLast() {
            if (size == 0) return null;
            return tail.prev;
        }

        public void removeLast() {
            if (size == 0) return;

            Node lastNode = tail.prev;
            Node prevNode = lastNode.prev;
            prevNode.next = tail;
            tail.prev = prevNode;
            size--;
        }

        public int size() {
            return size;
        }

    }
}





