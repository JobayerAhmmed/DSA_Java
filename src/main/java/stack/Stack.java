package main.java.stack;

/**
 * push() O(1) (Average)
 * pop() O(1)
 * peek() O(1)
 * empty() O(1)
 * search() O(n)
 * size()
 * contains()
 * clear()
 * toString()
 */
public class Stack {

    private Node top;

    public Stack() {
        top = null;
    }

    public void push(int data) {
        Node node = new Node(data);
        node.setNext(top);
        top = node;
    }

    public int pop() throws Exception {
        if (empty())
            throw new Exception("Stack is empty");
        int data = top.getData();
        top = top.getNext();
        return data;
    }

    public int peek() throws Exception {
        if (empty())
            throw new Exception("Stack is empty");
        return top.getData();
    }

    public boolean empty() {
        return (top == null);
    }

    // return 1 based index counting from top
    public int search(int data) {
        int index = 1;
        Node node = top;
        while (node != null) {
            if (node.getData() == data) {
                return index;
            }
            node = node.getNext();
            index++;
        }
        return -1;
    }

    public int size() {
        if (empty())
            return 0;
        int length = 0;
        Node node = top;
        while (node != null) {
            length++;
            node = node.getNext();
        }
        return length;
    }

    public boolean contains(int data) {
        Node node = top;
        while (node != null) {
            if (node.getData() == data)
                return true;
            node = node.getNext();
        }
        return false;
    }

    public void clear() {
        Node node;
        while (top != null) {
            node = top;
            top = top.getNext();
            node = null;
        }
    }

    public String toString() {
        String result = "[";
        Node node = top;
        while (node != null) {
            result = result + node.getData() + " ";
            node = node.getNext();
        }
        result = result + "]";
        return result;
    }

    public static void main(String[] args) {
        Stack stack = new Stack();
        System.out.println(stack);
        System.out.println(stack.empty());
        try {
            System.out.println(stack.peek());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        stack.push(5);
        stack.push(10);
        stack.push(15);
        stack.push(20);
        stack.push(25);
        System.out.println(stack);
        System.out.println(stack.search(20));
        System.out.println(stack.search(55));
        try {
            System.out.println(stack.peek());
            System.out.println(stack);
            System.out.println(stack.pop());
            System.out.println(stack);
            System.out.println(stack.pop());
            System.out.println(stack.pop());
            System.out.println(stack.pop());
            System.out.println(stack.pop());
            System.out.println(stack.pop());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // size
//        Stack sizeStack = new Stack();
//        System.out.println(sizeStack.size());
//        sizeStack.push(5);
//        System.out.println(sizeStack.size());
//        sizeStack.push(5);
//        sizeStack.push(5);
//        System.out.println(sizeStack.size());

        // contains
//        Stack containsStack = new Stack();
//        System.out.println(containsStack.contains(5));
//        containsStack.push(5);
//        containsStack.push(5);
//        containsStack.push(10);
//        System.out.println(containsStack.contains(5));
//        System.out.println(containsStack.contains(10));
//        System.out.println(containsStack.contains(55));

        // clear
//        Stack clearStack = new Stack();
//        System.out.println(clearStack);
//        clearStack.clear();
//        System.out.println(clearStack);
//        clearStack.push(5);
//        System.out.println(clearStack);
//        clearStack.clear();
//        System.out.println(clearStack);
//        clearStack.push(5);
//        clearStack.push(10);
//        System.out.println(clearStack);
//        clearStack.clear();
//        System.out.println(clearStack);
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
