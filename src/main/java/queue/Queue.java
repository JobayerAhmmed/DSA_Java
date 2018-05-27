package main.java.queue;

/**
 * add() O(1) (Average)
 * remove() O(1)
 * element() O(1)
 * isEmpty() O(1)
 * size()
 * contains()
 * clear()
 * toString()
 */
public class Queue {
    private Node front;
    private Node rear;

    public Queue() {
        front = null;
        rear = null;
    }

    public void add(int data) {
        Node node = new Node(data);
        if (isEmpty())
            front = node;
        else
            rear.setNext(node);
        rear = node;
    }

    public int remove() throws Exception {
        if (isEmpty())
            throw new Exception("Queue is empty");
        int data = front.getData();
        front = front.getNext();
        if (isEmpty())
            rear = null;
        return data;
    }

    public int element() throws Exception {
        if (isEmpty())
            throw new Exception("Queue is empty");
        return front.getData();
    }

    public boolean isEmpty() {
        return front == null;
    }

    public int size() {
        if (isEmpty())
            return 0;
        int length = 0;
        Node node = front;
        while (node != null) {
            length++;
            node = node.getNext();
        }
        return length;
    }

    public boolean contains(int data) {
        Node node = front;
        while (node != null) {
            if (node.getData() == data)
                return true;
            node = node.getNext();
        }
        return false;
    }

    public void clear() {
        Node node;
        while (front != null) {
            node = front;
            front = front.getNext();
            node = null;
        }
    }

    public String toString() {
        String result = "[";
        Node node = front;
        while (node != null) {
            result = result + node.getData() + " ";
            node = node.getNext();
        }
        result = result + "]";
        return result;
    }

    public static void main(String[] args) {
        // add
        Queue queue = new Queue();
        queue.add(5);
        queue.add(10);
        queue.add(10);
        queue.add(10);
        queue.add(10);
        System.out.println(queue.toString());

        // remove
//        Queue queue = new Queue();
//        try {
//            queue.remove();
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//        queue.add(5);
//        queue.add(10);
//        queue.add(15);
//        System.out.println(queue.toString());
//        try {
//            System.out.println(queue.remove());
//            System.out.println(queue.remove());
//            System.out.println(queue.remove());
//            System.out.println(queue.remove());
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }

        // element
//        Queue queue = new Queue();
//        try {
//            System.out.println(queue.element());
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//        queue.add(5);
//        try {
//            System.out.println(queue.element());
//            queue.remove();
//            System.out.println(queue.element());
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//        queue.add(5);
//        queue.add(10);
//        try {
//            System.out.println(queue.element());
//            System.out.println(queue.element());
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }

        // isEmpty
//        Queue queue = new Queue();
//        System.out.println(queue.isEmpty());
//        queue.add(5);
//        System.out.println(queue.isEmpty());

        // size
//        Queue queue = new Queue();
//        System.out.println(queue.size());
//        queue.add(5);
//        System.out.println(queue.size());

        // contains
//        Queue queue = new Queue();
//        System.out.println(queue.contains(5));
//        queue.add(5);
//        queue.add(5);
//        queue.add(10);
//        System.out.println(queue.contains(5));
//        System.out.println(queue.contains(10));
//        System.out.println(queue.contains(55));

        // clear
//        Queue queue = new Queue();
//        System.out.println(queue);
//        queue.clear();
//        System.out.println(queue);
//        queue.add(5);
//        queue.clear();
//        System.out.println(queue);
    }

    private class Node {
        private int data;
        private Node next;

        public Node(int data) {
            this.data = data;
        }

        public int getData() {
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
