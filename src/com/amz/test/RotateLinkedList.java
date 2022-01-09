package com.amz.test;

class RotateLinkedList {
    public Node rotateRight(Node head, int k) {
        int count =0;
        if (k==0) {
            return head;
        }
        if (head == null || head.next== null) {
            return head;
        }
        Node current = head;
        while(current.next != null) {
            count++;
            current = current.next;
        }

        if (k%count == 0 ) {
            return head;
        }

        k = count-(k%count);
        current = head;
        Node prev = null;
        for(int i=0; i<k; i++) {
            prev= current;
            current = current.next;
        }

        Node last = current;
        while(last.next != null) {
            last = last.next;
        }
        last.next = head;
        prev.next = null;
        return current;

    }
}