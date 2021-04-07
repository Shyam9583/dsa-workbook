package com.technotap.dsaworkbook.stackqueue;

import java.util.HashMap;

public class LRUCache {

    private static Node head, tail;
    private static int capacity;
    private static HashMap<Integer, Node> map;

    private static void init(int cap) {
        capacity = cap;
        map = new HashMap<>();
    }

    private static void set(int key, int value) {
        if (map.isEmpty()) {
            head = tail = new Node(key, value);
            map.put(key, head);
            return;
        }
        Node node;
        if (map.containsKey(key)) {
            if (head == tail) return;
            node = map.get(key);
            node.value = value;
            if (node.prev != null)
                node.prev.next = node.next;
            if (node.next != null)
                node.next.prev = node.prev;
            if (head == node)
                head = head.next;
        } else {
            if (capacity == map.size()) {
                map.remove(head.key);
                head = head.next;
            }
            node = new Node(key, value);
            map.put(key, node);
        }
        tail.next = node;
        node.prev = tail;
        tail = node;
    }

    private static int get(int key) {
        if (map.containsKey(key)) {
            return map.get(key).value;
        } else return -1;
    }

    public static void main(String[] args) {
        init(2);
        set(1, 2);
        set(2, 3);
        set(1, 5);
        set(4, 5);
        set(6, 7);
        System.out.println(get(4));
        System.out.println(get(1));
    }

    private static class Node {
        int key, value;
        Node prev, next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.prev = this.next = null;
        }
    }

}
