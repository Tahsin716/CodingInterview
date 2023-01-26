package com.linkedlist.basic_linkedlist.copy_list_with_random_pointer;

import java.util.HashMap;

public class CopyListWithRandomPointer {
    public Node copyRandomList(Node head) {
        if (head == null) return null;

        // Use a HashMap to copy all the nodes without any linking of pointers,
        // map the original node with its copied node
        HashMap<Node, Node> map = new HashMap<>();
        Node node = head;

        // Iterate the linked list and insert a new copied node
        while (node != null) {
            map.put(node, new Node(node.val));
            node = node.next;
        }

        node = head;

        // Iterate the linked list again to connect the pointers
        while (node != null) {
            // Get the copied node from map for current node, and assign its next node
            map.get(node).next = map.get(node.next);
            // Assign the random pointer for copied node
            map.get(node).random = map.get(node.random);
            node = node.next;
        }

        return map.get(head);
    }

    private class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
