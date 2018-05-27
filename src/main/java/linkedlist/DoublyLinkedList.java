package main.java.linkedlist;

/**
 * add()
 * remove()
 * size()
 * contains()
 * indexOf()
 * clear()
 * print()
 */

public class DoublyLinkedList {
    private Node head;

    public DoublyLinkedList() {}

    public synchronized boolean add(Object data) {
        Node node = new Node(data);
        // if empty, add as head
        if (head == null) {
            head = node;
            return true;
        }

        Node previous, current;
        for (previous = head; (current = previous.getNext()) != null; previous = current);
        previous.setNext(node);
        node.setPrevious(previous);
        return true;
    }

    public synchronized boolean add(Object data, int index) {
        if (index < 0)
            return false;

        Node node = new Node(data);
        // insert at the beginning
        if (index == 0) {
            if (head == null) {
                head = node;
            }
            else {
                node.setNext(head);
                head.setPrevious(node);
                head = node;
            }
            return true;
        }

        if (index >= size())
            return false;

        // insert at index
        Node previous = head;  // 0 node
        Node current = head.getNext(); // 1 node
        for (int i = 2; i <= index; i++) {
            previous = current;
            current = current.getNext();
        }
        previous.setNext(node);
        node.setPrevious(previous);
        node.setNext(current);
        current.setPrevious(node);
        return true;
    }

    public synchronized Node remove(Object data) {
        if (head == null)
            return null;

        Node node = head;
        // remove from begin
        if (head.getData().equals(data)) {
            if (head.getNext() == null) {
                head = null;
                return node;
            }
            head = head.getNext();
            head.setPrevious(null);
            node.setNext(null);
            return node;
        }

        // remove from middle
        while (node.getNext() != null) {
            if (node.getData().equals(data)) {
                node.getPrevious().setNext(node.getNext());
                node.getNext().setPrevious(node.getPrevious());
                node.setNext(null);
                node.setPrevious(null);
                return node;
            }
            node = node.getNext();
        }

        // remove from end
        if (node.getData().equals(data)) {
            node.getPrevious().setNext(null);
            node.setPrevious(null);
            node.setNext(null);
            return node;
        }
        return null;
    }

    public synchronized Node remove(int index) {
        if (index < 0 || index >= size())
            return null;

        // remove head
        Node node = head;
        if (index == 0) {
            if (head.getNext() == null) {
                head = null;
                return node;
            }
            head = head.getNext();
            head.setPrevious(null);
            node.setNext(null);
            return node;
        }

        // find node at index
        Node previous = null;
        for (int i = 1; i <= index; i++) {
            previous = node;
            node = node.getNext();
        }
        // remove from end
        if (node.getNext() == null) {
            previous.setNext(null);
            node.setPrevious(null);
            return node;
        }
        // remove at index
        previous.setNext(node.getNext());
        node.getNext().setPrevious(node.getPrevious());
        node.setPrevious(null);
        node.setNext(null);

        return node;
    }

    public int size() {
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

    public boolean contains(Object data) {
        Node node = head;
        while (node != null && !(node.getData().equals(data)))
            node = node.getNext();
        if (node == null)
            return false;
        return true;
    }

    public int indexOf(Object data) {
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

    public void clear() {
        Node node;
        while (head != null) {
            node = head;
            head = head.getNext();
            if (head != null)
                head.setPrevious(null);
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

    public static void main(String[] args) {

        // add
        DoublyLinkedList list = new DoublyLinkedList();
        list.print();
        list.add(5);
        list.print();
        list.add(10);
        list.add(15);
        list.print();

        // add(index)
//        DoublyLinkedList addIndexList = new DoublyLinkedList();
//        addIndexList.add(5, 0);
//        addIndexList.print();
//        addIndexList.add(10, 0);
//        addIndexList.print();
//        addIndexList.add(15, 0);
//        addIndexList.print();
//        addIndexList.add(20, 2);
//        addIndexList.print();
//        addIndexList.add(25, 1);
//        addIndexList.print();
//        System.out.println();

        // remove
//        DoublyLinkedList removeList = new DoublyLinkedList();
//        System.out.println(removeList.remove(new Integer(5)));
//        removeList.add(5);
//        removeList.remove(new Integer(5));
//        removeList.print();
//        removeList.remove(new Integer(5));
//        removeList.print();
//        removeList.add(5);
//        removeList.add(10);
//        removeList.add(15);
//        removeList.add(20);
//        removeList.print();
//        removeList.remove(new Integer(55));
//        removeList.print();
//        removeList.remove(new Integer(5));
//        removeList.print();
//        removeList.remove(new Integer(10));
//        removeList.print();
//        removeList.remove(new Integer(20));
//        removeList.print();
//        removeList.remove(new Integer(15));
//        removeList.print();

        // remove(index)
//        DoublyLinkedList removeIndexList = new DoublyLinkedList();
//        DNode removedIndexNode = removeIndexList.remove(0);
//        System.out.println(removedIndexNode);
//        removeIndexList.add(5);
//        removedIndexNode = removeIndexList.remove(0);
//        System.out.println(removedIndexNode.getData());
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
//        removeIndexList.remove(2);
//        removeIndexList.print();
//        removeIndexList.remove(1);
//        removeIndexList.print();
//        removeIndexList.remove(0);
//        removeIndexList.print();

        // size
//        DoublyLinkedList sizeList = new DoublyLinkedList();
//        System.out.println(sizeList.size());
//        sizeList.add(5);
//        System.out.println(sizeList.size());
//        sizeList.add(10);
//        sizeList.add(15);
//        System.out.println(sizeList.size());

        // contains
//        DoublyLinkedList containsList = new DoublyLinkedList();
//        System.out.println(containsList.contains(5));
//        containsList.add(5);
//        System.out.println(containsList.contains(5));
//        System.out.println(containsList.contains(0));
//        containsList.add(10);
//        containsList.add(15);
//        containsList.add(20);
//        System.out.println(containsList.contains(10));
//        System.out.println(containsList.contains(15));
//        System.out.println(containsList.contains(20));
//        System.out.println(containsList.contains(25));

        // indexOf
//        DoublyLinkedList indexOfList = new DoublyLinkedList();
//        System.out.println(indexOfList.indexOf(5));
//        indexOfList.add(5);
//        System.out.println(indexOfList.indexOf(5));
//        indexOfList.add(10);
//        indexOfList.add(15);
//        System.out.println(indexOfList.indexOf(10));
//        System.out.println(indexOfList.indexOf(15));
//        System.out.println(indexOfList.indexOf(20));

        // clear
//        DoublyLinkedList clearList = new DoublyLinkedList();
//        clearList.clear();
//        clearList.add(5);
//        clearList.add(5);
//        clearList.add(5);
//        clearList.add(5);
//        clearList.add(5);
//        clearList.print();
//        clearList.clear();
//        clearList.print();
    }

    // inner class can be private
    private class Node {
        private Object data;
        private Node previous;
        private Node next;

        public Node(Object data) {
            this.data = data;
        }

        public Object getData() {
            return data;
        }

        public Node getPrevious() {
            return previous;
        }

        public void setPrevious(Node previous) {
            this.previous = previous;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
}
