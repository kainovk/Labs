package com.company;

public class MyList<T> {

    private Node head;

    private class Node<T> {

        T data;
        Node next;
        Node prev;

        Node(T data) {
            this.data = data;
        }
    }

    public void pushFront(T data) {

        Node node = new Node(data);
        node.prev = null;
        node.next = head;

        if (head != null) {
            head.prev = node;
        }
        head = node;
    }

    public void pushBack(T data) {

        Node node = new Node(data);
        node.next = null;

        Node tail = head;
        if (head == null) {
            node.prev = null;
            head = node;
            return;
        }

        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = node;
        node.prev = tail;
    }

    public boolean insert(int index, T data) {
        
        if(index == 0) {
            pushFront(data);
            return true;
        }

        Node node = new Node(data);
        Node tail = head;

        int i;
        for (i = 0; tail.next != null && i < index; tail = tail.next, i++) {
        }

        if (i == index) {
            tail.prev.next = node;
            node.prev = tail.prev;
            node.next = tail;
            tail.prev = node;

            return true;
        }

        return false;
    }

    public boolean delete(T data) {

        if (head == null) {
            return false;
        }

        // first
        if (head.data == data) {
            if (head.next == null) {
                head = null;
                return true;
            }

            head = head.next;
            head.prev = null;
            return true;
        }

        // middle
        Node node = head;
        while (node.next != null) {
            if (node.data == data) {
                node.prev.next = node.next;
                node.next.prev = node.prev;
                return true;
            }

            node = node.next;
        }

        // last
        if (node != head) {
            if (node.data == data) {
                node.prev.next = null;
                return true;
            }
        }

        return false;
    }

    public void display() {

        if (head == null) {
            System.out.println("EMPTY!");
        }

        Node node = head;
        while (node != null) {
            System.out.print(node.data);
            System.out.print(" ");
            node = node.next;
        }
        System.out.println();
    }
}
