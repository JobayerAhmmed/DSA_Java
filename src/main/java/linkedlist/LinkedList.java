package main.java.linkedlist;

/**
 * add()
 * remove()
 * size()
 * contains()
 * indexOf()
 * clear()
 * print()
 * */

public class LinkedList {
    private Node head;

    // O(n)
    public synchronized boolean add(Object data) {
        Node node = new Node(data);
        // if list is empty, add as head
        if (head == null) {
            head = node;
        }
        else {
            Node p, q;
            for (p = head; (q = p.getNext()) != null; p = q);
            p.setNext(node);
        }
        return true;
    }

    // O(n)
    public synchronized boolean add(Object data, int index) {
        if (index < 0)
            return false;

        Node node = new Node(data);

        // insert at the beginning
        if (index == 0) {
            // if empty
            if (head == null) {
                head = node;
            }
            else {
                node.setNext(head);
                head = node;
            }
            return true;
        }
        if (index >= size())
            return false;

        // insert at the specified index
        Node previousNode = head;   // 0 node
        Node currentNode = previousNode.getNext(); // 1 node
        for (int i = 2; i <= index; i++) {
            previousNode = currentNode;
            currentNode = previousNode.getNext();
        }
        previousNode.setNext(node);
        node.setNext(currentNode);
        return true;
    }

    // O(n)
    public synchronized Node remove(Object data) {
        if (head == null)
            return null;

        Node node = head;
        // remove from begin
        if (head.getData().equals(data)) {
            head = node.getNext();
            node.setNext(null);
            return node;
        }
        // remove from middle
        Node previous = null;
        while (node.getNext() != null) {
            if (node.getData().equals(data)) {
                previous.setNext(node.getNext());
                return node;
            }
            previous = node;
            node = node.getNext();
        }
        // remove from end
        if (node.getData().equals(data)) {
            previous.setNext(null);
            return node;
        }
        return null;
    }

    // O(n)
    public synchronized Node remove(int index) {
        if (index < 0 || index >= size())
            return null;
        // empty
        if (head == null)
            return null;

        // remove head
        Node node = head;
        if (index == 0) {
            head = head.getNext();
            return node;
        }

        // remove from index
        Node previous = null;
        for (int i = 1; i <= index; i++) {
            previous = node;
            node = node.getNext();
        }
        previous.setNext(node.getNext());
        return node;
    }

    // O(n)
    public synchronized int size() {
        if (head == null)
            return 0;
        if (head.getNext() == null)
            return 1;

        Node node = head;
        int length = 1;
        while (node.getNext() != null) {
            node = node.getNext();
            length++;
        }
        return length;
    }

    // O(n)
    public synchronized boolean contains(Object data) {
        Node node = head;
        while (node != null && !(node.getData().equals(data))) {
            node = node.getNext();
        }
        if (node == null)
            return false;
        return true;
    }

    // O(n)
    public synchronized int indexOf(Object data) {
        int index = 0;
        Node node = head;
        while (node != null) {
            if (node.getData().equals(data)) {
                return index;
            }
            node = node.getNext();
            index++;
        }
        return -1;
    }

    // O(n)
    public synchronized void clear() {
        Node node;
        while (head != null) {
            node = head;
            head = head.getNext();
            node = null;
        }
    }

    public void print() {
        Node node = head;
        while (node != null) {
            System.out.print(node.getData() + " ");
            node = node.getNext();
        }
        System.out.println();
    }

    public void print(int index) {
        Object data;
        if (index < 0)
            data = null;
        else if (index >= size())
            data = null;
        else {
            Node node = head;
            if (size() == 1)
                data = node.getData();
            else {
                for (int i = 1; i <= index; i++) {
                    node = node.getNext();
                }
                data = node.getData();
            }
        }
        System.out.println(data);
    }

    public static void main(String[] args) {

        // add
        LinkedList linkedList = new LinkedList();
        linkedList.add(5);
        linkedList.add(10);
        linkedList.add(15);
        linkedList.add(20);
        linkedList.add(25);
        linkedList.print();

        // add(index)
//        LinkedList addIndexList = new LinkedList();
//        addIndexList.add(5, 0);
//        addIndexList.print();
//        addIndexList.add(10, 0);
//        addIndexList.print();
//        addIndexList.add(15, 1);
//        addIndexList.print();
//        addIndexList.add(20, 5);
//        addIndexList.print();
//        System.out.println();

        // remove
//        LinkedList removeList = new LinkedList();
//        removeList.add(5);
//        removeList.remove(new Integer(5));
//        removeList.print();
//        removeList.add(5);
//        removeList.add(10);
//        removeList.add(15);
//        removeList.add(20);
//        removeList.add(25);
//        removeList.add(30);
//        removeList.print();
//        removeList.remove(new Integer(5));
//        removeList.print();
//        removeList.remove(new Integer(30));
//        removeList.print();
//        removeList.remove(new Integer(20));
//        removeList.print();
//        removeList.remove(new Integer(10));
//        removeList.print();
//        removeList.remove(new Integer(25));
//        removeList.print();
//        Node node = removeList.remove(new Integer(55));
//        removeList.print();
//        System.out.println(node);
//        removeList.remove(new Integer(15));
//        removeList.print();
//        removeList.remove(new Integer(1));
//        removeList.print();
//        System.out.println();

        // remove(index)
//        LinkedList removeIndexList = new LinkedList();
//        removeIndexList.add(5);
//        removeIndexList.print();
//        removeIndexList.remove(0);
//        removeIndexList.print();
//        removeIndexList.add(5);
//        removeIndexList.add(10);
//        removeIndexList.add(15);
//        removeIndexList.add(20);
//        removeIndexList.add(25);
//        removeIndexList.print();
//        removeIndexList.remove(0);
//        removeIndexList.print();
//        removeIndexList.remove(3);
//        removeIndexList.print();
//        removeIndexList.remove(1);
//        removeIndexList.print();
//        Node indexRemovedNode = removeIndexList.remove(11);
//        System.out.println(indexRemovedNode);
//        removeIndexList.remove(0);
//        removeIndexList.print();
//        removeIndexList.remove(0);
//        removeIndexList.print();
//        System.out.println();

        // size
//        LinkedList sizeList = new LinkedList();
//        System.out.println(sizeList.size());
//        sizeList.add(5);
//        System.out.println(sizeList.size());
//        sizeList.add(10);
//        System.out.println(sizeList.size());
//        System.out.println();
//
        // contains
//        LinkedList containslist = new LinkedList();
//        containslist.add(5);
//        containslist.add(10);
//        containslist.add(15);
//        System.out.println(containslist.contains(5));
//        System.out.println(containslist.contains(10));
//        System.out.println(containslist.contains(15));
//        System.out.println(containslist.contains(55));
//        System.out.println();

        // indexOf
//        LinkedList indexOfList = new LinkedList();
//        indexOfList.add(5);
//        indexOfList.add(10);
//        indexOfList.add(15);
//        indexOfList.add(20);
//        indexOfList.add(25);
//        System.out.println(indexOfList.indexOf(5));
//        System.out.println(indexOfList.indexOf(25));
//        System.out.println(indexOfList.indexOf(10));
//        System.out.println(indexOfList.indexOf(55));
//        System.out.println();

        // clear
//        LinkedList clearList = new LinkedList();
//        clearList.add(5);
//        clearList.add(15);
//        clearList.add(20);
//        clearList.print();
//        clearList.clear();
//        clearList.print();

//         print
//        LinkedList printList = new LinkedList();
//        printList.add(5);
//        printList.add(10);
//        printList.add(15);
//        printList.print(0);
//        printList.print(1);
//        printList.print(2);
//        printList.print();
    }

    // inner class can be private
    private class Node {
        private Object data;
        private Node next;

        public Node(Object data) {
            this.data = data;
        }

        public Object getData() {
            return data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
}