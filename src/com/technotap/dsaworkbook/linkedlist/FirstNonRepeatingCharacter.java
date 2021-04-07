package com.technotap.dsaworkbook.linkedlist;

import java.util.HashMap;

public class FirstNonRepeatingCharacter {

    public static void main(String[] args) {
        String string = "zzabccdb";
        System.out.println(firstNonRepeatingMap(string));
    }

    private static String firstNonRepeating(String stream) {
        HashedLinkedList list = new HashedLinkedList();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < stream.length(); i++) {
            char c = list.process(stream.charAt(i));
            builder.append(c);
        }
        return builder.toString();
    }

    private static String firstNonRepeatingMap(String stream) {
        HashMap<Character, Integer> map = new HashMap<>();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < stream.length(); i++) {
            char character = stream.charAt(i);
            if (!map.containsKey(character)) {
                map.put(character, 1);
            } else {
                map.replace(character, map.get(character) + 1);
            }
            char first = '#';
            for (char key : map.keySet()) {
                if (map.get(key) == 1) {
                    first = key;
                    break;
                }
            }
            result.append(first);
        }
        return result.toString();
    }

    private static class Node {
        char data;
        Node prev, next;

        Node(char data) {
            this.data = data;
        }
    }

    private static class HashedLinkedList {
        Node head, tail;
        Node[] nodes = new Node[26];

        private void insert(char data) {
            int index = data - 'a';
            nodes[index] = new Node(data);
            if (head == null) {
                head = nodes[index];
                tail = head;
            } else {
                tail.next = nodes[index];
                tail.next.prev = tail;
                tail = tail.next;
            }
        }

        private char peek() {
            if (head == null)
                return '#';
            return head.data;
        }

        private void delete(char key) {
            if (head == null) return;
            Node target = nodes[key - 'a'];
            if (head == tail) {
                if (head.data == key) {
                    head = null;
                    tail = null;
                }
            } else {
                if (head.data == key) {
                    head = head.next;
                    head.prev = null;
                } else if (tail.data == key) {
                    tail = tail.prev;
                    tail.next = null;
                } else if (target.prev != null && target.next != null) {
                    target.prev.next = target.next;
                    target.next.prev = target.prev;
                    target.prev = null;
                    target.next = null;
                }
            }
        }

        char process(char key) {
            int index = key - 'a';
            if (nodes[index] == null) {
                insert(key);
            } else {
                delete(key);
            }
            return peek();
        }
    }

}
