package com.amz.cache;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    final Node head = new Node();
    final Node tail = new Node();
    Map<Integer, Node> nodeMap;
    int cache_capacity;

    public LRUCache(int capacity) {
        this.cache_capacity = capacity;
        nodeMap = new HashMap();
        head.next = tail;
        tail.prev= head;
    }

    public int get(int key) {
        int result = -1;
        Node node = nodeMap.get(key);
        if (node != null) {
            result = node.val;
            remove(node);
            add(node);
        }
        return result;
    }

    public void put(int key, int value) {
        Node node = nodeMap.get(key);
        if(node != null) {
            node.val = value;
            remove(node);
            add(node);
        } else {
            if (nodeMap.size() == cache_capacity) {
                nodeMap.remove(tail.prev.key);
                remove(tail.prev);
            }
            Node newNode = new Node();
            newNode.key = key;
            newNode.val= value;
            add(newNode);
        }
    }

    public void add(Node node) {
        Node head_next = head.next;
        head.next = node;
        node.prev = head;
        node.next= head_next;
        head_next.prev =node;
        nodeMap.put(node.key, node);
    }

    public void remove(Node node) {
        Node prev_node = node.prev;
        Node next_node = node.next;

        prev_node.next = next_node;
        next_node.prev= prev_node;
    }

    class Node {
        int key;
        int val;
        Node prev;
        Node next;
    }
}
