package main.java.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * build()
 * add()
 * remove()
 * contains() O(n)
 * max()    O(n)
 * size()
 * height()
 * deepest()
 * sum()
 * clear()
 * isStructurallyIdentical()
 * print()
 */
public class BinaryTree {

    private Node root;

    public BinaryTree() {
        root = null;
    }

    public void add(int data) {

        Node node = new Node(data);
        if (root == null) {
            root = node;
            return;
        }

        Queue<Node> queue = new LinkedList<Node>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            if (current != null) {
                if (current.getLeft() != null)
                    queue.offer(current.getLeft());
                else {
                    current.setLeft(node);
                    return;
                }

                if (current.getRight() != null)
                    queue.offer(current.getRight());
                else {
                    current.setRight(node);
                    return;
                }
            }
        }
    }

    public boolean contains(int data) {

        if (root == null)
            return false;

        Queue<Node> queue = new LinkedList<Node>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            if (current.getData() == data)
                return true;

            if (current.getLeft() != null)
                queue.offer(current.getLeft());

            if (current.getRight() != null)
                queue.offer(current.getRight());
        }

        return false;
    }

    public int max(Node root) {
        int maxValue = -1;
        if (root == null)
            return maxValue;

        int leftValue = max(root.getLeft());
        int rightValue = max(root.getRight());

        if (leftValue > rightValue)
            maxValue = leftValue;
        else
            maxValue = rightValue;

        if (root.getData() > maxValue)
            maxValue = root.getData();

        return maxValue;
    }

    public void print() {
        if (root == null) {
            System.out.println("---");
            return;
        }

        Queue<Node> currentLevel = new LinkedList<Node>();
        Queue<Node> nextLevel = new LinkedList<Node>();
        Queue<Node> temp;

        currentLevel.offer(root);
        while (!currentLevel.isEmpty()) {
            Node currentNode = currentLevel.poll();

            if (currentNode != null) {
                System.out.print(currentNode.getData() + " ");
                nextLevel.offer(currentNode.getLeft());
                nextLevel.offer(currentNode.getRight());
            }

            if (currentLevel.isEmpty()) {
                System.out.println();
                temp = currentLevel;
                currentLevel = nextLevel;
                nextLevel = temp;
            }
        }
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.add(1);
        tree.add(2);
        tree.add(3);
        tree.add(4);
        tree.add(5);
        tree.add(6);
        tree.add(7);
        tree.add(8);
        tree.print();

        System.out.println(tree.contains(7));
        System.out.println(tree.contains(10));
    }

    private class Node {

        private int data;
        private Node left;
        private Node right;

        public Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }
    }
}
