package com.stack_and_queue.lru_cache;

import java.util.HashMap;

public class LruCache {
    private final int capacity;
    private HashMap<Integer, Node> map;
    private Node head, tail;

    public LruCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>(capacity);
        this.head = new Node();
        this.tail = new Node();
    }

    public void put(int key, int value) {
        Node node = map.get(key);

        if (node == null) {
            if (map.size() == capacity) {
                Node leastRecentlyUsedNode = tail.prev;
                remove(leastRecentlyUsedNode);
            }
        } else {
            remove(node);
        }

        add(new Node(key, value));
    }

    public int get(int key) {
        Node node = map.get(key);

        if (node == null) return -1;

        remove(node);
        add(node);

        return node.value;
    }

    private void add(Node node) {
        map.put(node.key, node);
        Node headNode = head.next;

        head.next = node;
        headNode.prev = node;

        node.prev = head;
        node.next = headNode;
    }

    private void remove(Node node) {
        map.remove(node.key);
        Node prevNode = node.prev;
        Node nextNode = node.next;

        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }
    private class Node {
        int key, value;
        Node prev, next;

        public Node() {

        }

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}


