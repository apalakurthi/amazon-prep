package com.amz.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/**
 * https://leetcode.com/problems/merge-k-sorted-lists/
 * */
public class MergeKSortedList {
    public static void main(String[] args) {
        int k = 3; // Number of linked lists
        int n = 4; // Number of elements in each list

        // an array of pointers storing the head nodes
        // of the linked lists
        Node arr[] = new Node[k];

        arr[0] = new Node(1);
        arr[0].next = new Node(3);
        arr[0].next.next = new Node(5);
        arr[0].next.next.next = new Node(7);

        arr[1] = new Node(2);
        arr[1].next = new Node(4);
        arr[1].next.next = new Node(6);
        arr[1].next.next.next = new Node(8);

        arr[2] = new Node(0);
        arr[2].next = new Node(9);
        arr[2].next.next = new Node(10);
        arr[2].next.next.next = new Node(11);

        // Merge all lists
        MergeKSortedList merge = new MergeKSortedList();
        //Node result = merge.bruteForceSort(arr);
        Node result = merge.divideAndConquer(arr);

        while(result.next != null) {
            System.out.print(result.val +" ");
            result = result.next;
        }

    }

    public Node bruteForceSort(Node arr[]) {

        List<Integer> list = new ArrayList<>();
        for(int i=0; i<arr.length; i++) {
            Node current = arr[i];
            while(current != null) {
                list.add(current.val);
                current = current.next;
            }
        }
        Collections.sort(list);
        Node root = new Node(0);
        Node current = new Node(list.get(0));
        root.next= current;
        for (int i=1; i<list.size(); i++) {
            Node node = new Node(list.get(i));
            current.next = node;
            current = node;
        }

        return root.next;
    }

    public Node divideAndConquer(Node[] arr) {
        if (arr== null || arr.length == 0)  return null;
        return mergeKLists(arr, 0, arr.length-1);
    }

    private Node mergeKLists(Node[] arr, int start , int end) {
        if(start== end) return arr[start];

        int mid = start+(end-start)/2;
        Node left = mergeKLists(arr, start, mid);
        Node right = mergeKLists(arr, mid+1, end);
        return merge(left, right);
    }

    private Node merge(Node left, Node right) {
        Node result = new Node(-1);
        Node current = result;
        while(left != null || right != null) {
            if (left == null) {
                current.next= right;
                right = right.next;
            } else if (right == null) {
                current.next= left;
                left = left.next;
            } else if (left.val < right.val) {
                current.next= left;
                left = left.next;
            } else {
                current.next = right;
                right = right.next;
            }
            current = current.next;
        }
        return result.next;
    }

}
